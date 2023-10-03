package com.metavirtual.bloom.myPage.adminPage.controller;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.AdminCriteria;
import com.metavirtual.bloom.common.paging.Paging;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dto.AdminCommentDTO;
import com.metavirtual.bloom.myPage.adminPage.model.dto.CsDetailDTO;
import com.metavirtual.bloom.myPage.adminPage.model.dto.CsListDTO;
import com.metavirtual.bloom.myPage.adminPage.model.service.AdminPageServiceImpl;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ReservationDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import com.metavirtual.bloom.user.model.dto.UserImpl;
import org.apache.ibatis.annotations.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/admin")
@Controller
public class AdminPageController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final AdminPageServiceImpl adminPageService;

    public AdminPageController(AdminPageServiceImpl adminPageService){
        this.adminPageService = adminPageService;
    }
    @GetMapping("/")
    public String adminPage() {
        return "mypage/admin/adminPage";
    }

    @GetMapping("/customerService")
    public ModelAndView customerService(HttpServletRequest request,
                                        @RequestParam(value = "currentPage", defaultValue = "1") int pageNo, ModelAndView mv) {
        log.info("");
        log.info("[AdminPageController] ========");


        int totalCsCount = adminPageService.selectCsCount();
        log.info("[AdminPageController] totalCsCount" + totalCsCount);

        int limitPerPage = 10;
        int buttonAmount = 10;

        SelectCriteria selectCriteria = Paging.getSelectCriteria(pageNo, totalCsCount, limitPerPage, buttonAmount);

        log.info("[AdminPageController] selectCriteria : "+selectCriteria);

        List<CsListDTO> csList = adminPageService.selectCsList(selectCriteria);

        log.info("[AdminPageController] csList : "+csList);

        mv.addObject("csList", csList);
        mv.addObject("selectCriteria", selectCriteria);
        log.info("[AdminPageController] selectCriteria : "+selectCriteria);
        mv.setViewName("/mypage/admin/customerService");

        log.info("[AdminPageController] ========");

        return mv;
    }


    @GetMapping("/editMemberInfo")
    public String editMemberInfo(HttpServletRequest request, Model model) {
        log.info("");
        log.info("[AdminPageController] ========");
        String userId = request.getParameter("userId");


        return "mypage/admin/editMemberInfo";

    }

    @GetMapping("/editTherapistInfo")
    public String editTherapistInfo(HttpServletRequest request, Model model) {
        log.info("");
        log.info("[AdminPageController] ========");

        String userId = request.getParameter("userId");
        return "mypage/admin/editTherapistInfo";

    }

    @GetMapping("/csAnswer")
    public String csAnswer(HttpServletRequest request, Model model, Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()){
            UserImpl user = (UserImpl) authentication.getPrincipal();
            model.addAttribute("user", user);
        }
        log.info("");
        log.info("[AdminPageController] ========");

        int boardCode = Integer.parseInt(request.getParameter("boardCode"));

        CsDetailDTO csDetail = adminPageService.selectCsDetail(boardCode);
        log.info("[AdminPageController] csDetail : " + csDetail);
        model.addAttribute("csDetail", csDetail);

        log.info("[AdminPageController] ========");
        return "mypage/admin/csAnswer";
    }

    @PostMapping("/csAnswer")
    public String csAnswer(@ModelAttribute AdminCommentDTO comment, RedirectAttributes rttr){
        log.info("");
        log.info("[AdminPageController] ========");
        log.info("[AdminPageController] registComment Request : " + comment);

        try {
            adminPageService.registComment(comment);
            rttr.addFlashAttribute("cSuccessMessage", "답변 등록에 성공했습니다!");
        } catch(ModifyInfoException e) {
            rttr.addFlashAttribute("cErrorMessage", "답변 등록에 실패했습니다. 다시 시도해주세요.");
        }
        return "redirecr:/admin/customerService";
    }

    @GetMapping("/inquireMember")
    public ModelAndView inquireMember(@RequestParam(required = false) String searchSelect,
                                      @RequestParam(required = false) String searchValue,
                                      @RequestParam(value = "currentPage", defaultValue = "1") int pageNo, ModelAndView mv){
        log.info("");
        log.info("[AdminPageController] ========");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchSelect", searchSelect);
        searchMap.put("searchValue", searchValue);

        log.info("[AdminPageController] 검색조건 확인하기 : " + searchMap);


        int totalMemberCount = adminPageService.selectMemberCount(searchMap);
        log.info("[AdminPageController] totalMemberCount" + totalMemberCount);

        int limitPerPage = 10;
        int buttonAmount = 10;

        AdminCriteria adminCriteria;

        if(searchSelect != null && !"".equals(searchSelect)) {
            adminCriteria = Paging.getAdminCriteria(pageNo, totalMemberCount, limitPerPage, buttonAmount, searchSelect, searchValue);
        } else {
            adminCriteria = Paging.getAdminCriteria(pageNo, totalMemberCount, limitPerPage, buttonAmount);
        }

        log.info("[AdminPageController] adminCriteria : "+adminCriteria);

        List<UserDTO> memberList = adminPageService.selectMemberList(adminCriteria);

        log.info("[AdminPageController] memberList : "+memberList);

        mv.addObject("memberList", memberList);
        mv.addObject("adminCriteria", adminCriteria);
        log.info("[AdminPageController] adminCriteria : "+adminCriteria);
        mv.setViewName("/mypage/admin/inquireMember");

        log.info("[AdminPageController] ========");

        return mv;
    }

    @PatchMapping("/unregistMember")
    public ResponseEntity<List<UserDTO>> unregistMember(@RequestBody UserDTO unregistMember) throws ModifyInfoException {

        log.info("");
        log.info("[AdminPageController] ========");
        log.info("[AdminPageController] unregistMember Request : " + unregistMember);

        List<UserDTO> unregistList = adminPageService.unregistMember(unregistMember);

        log.info("[AdminPageController] unregistList : " + unregistList);
        log.info("[AdminPageController] ========");

        return ResponseEntity.ok(unregistList);
    }

    @GetMapping("/inquireTherapist")
    public ModelAndView inquireTherapist(@RequestParam(required = false) String searchSelect,
                                         @RequestParam(required = false) String searchValue,
                                         @RequestParam(value = "currentPage", defaultValue = "1") int pageNo, ModelAndView mv){
        log.info("");
        log.info("[AdminPageController] ========");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchSelect", searchSelect);
        searchMap.put("searchValue", searchValue);

        log.info("[AdminPageController] 검색조건 확인하기 : " + searchMap);


        int totalTherapistCount = adminPageService.selectTherapistCount(searchMap);
        log.info("[AdminPageController] totalTherapistCount" + totalTherapistCount);

        int limitPerPage = 10;
        int buttonAmount = 10;

        AdminCriteria adminCriteria;

        if(searchSelect != null && !"".equals(searchSelect)) {
            adminCriteria = Paging.getAdminCriteria(pageNo, totalTherapistCount, limitPerPage, buttonAmount, searchSelect, searchValue);
        } else {
            adminCriteria = Paging.getAdminCriteria(pageNo, totalTherapistCount, limitPerPage, buttonAmount);
        }

        log.info("[AdminPageController] adminCriteria : "+adminCriteria);

        List<UserDTO> therapistList = adminPageService.selectTherapistList(adminCriteria);

        log.info("[AdminPageController] therapistList : "+therapistList);

        mv.addObject("therapistList", therapistList);
        mv.addObject("adminCriteria", adminCriteria);
        log.info("[TherapistController] adminCriteria : "+adminCriteria);
        mv.setViewName("mypage/admin/inquireTherapist");

        log.info("[AdminPageController] ========");

        return mv;
    }

    @GetMapping("/report")
    public String report(){
        return "mypage/admin/report";
    }
}


//push용 주석
