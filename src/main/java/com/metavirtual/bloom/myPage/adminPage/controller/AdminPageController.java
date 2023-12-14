package com.metavirtual.bloom.myPage.adminPage.controller;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.BoardReportDTO;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.AdminCriteria;
import com.metavirtual.bloom.common.paging.Paging;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dto.*;
import com.metavirtual.bloom.myPage.adminPage.model.service.AdminPageServiceImpl;
import com.metavirtual.bloom.myPage.memberPage.model.dto.CommentListDTO;
import com.metavirtual.bloom.myPage.memberPage.model.dto.MemberInfo;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.BookInfo;
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
    public ModelAndView editMemberInfo(HttpServletRequest request, ModelAndView mv, Model model,
                                       @RequestParam(name = "currentPage", defaultValue = "1") int ppageNo,
                                       @RequestParam(name = "currentPage", defaultValue = "1") int rpageNo) {
        log.info("");
        log.info("[AdminPageController] ========");
        String userId = request.getParameter("userId");

        MemberInfo member = adminPageService.memberInfo(userId);
        model.addAttribute("member", member);

        int totalReportCount = adminPageService.selectTotalReportCount(userId);
        model.addAttribute("count", totalReportCount);
        int totalPostCount = adminPageService.selectTotalPostCount(userId);
        log.info("[MemberPageController] totalReportCount : "+totalReportCount);
        log.info("[MemberPageController] totalPostCount : "+totalPostCount);

        int limitPerPage1 = 5;
        int buttonAmount1 = 5;

        int limitPerPage2 = 5;
        int buttonAmount2 = 5;

        SelectCriteria selectCriteria1 = Paging.getSelectCriteria(rpageNo, totalReportCount, limitPerPage1, buttonAmount1);
        SelectCriteria selectCriteria2 = Paging.getSelectCriteria(ppageNo, totalPostCount, limitPerPage2, buttonAmount2);

        log.info("[MemberPageController] selectCriteria1 : "+selectCriteria1);
        log.info("[MemberPageController] selectCriteria2 : "+selectCriteria2);


        List<PostResult> postList = adminPageService.selectPostList(selectCriteria2, userId);
        List<MemberReport> reportList = adminPageService.selectReportList(selectCriteria1, userId);

        log.info("[MemberPageController] postList : "+postList);
        log.info("[MemberPageController] reportList : "+reportList);

        mv.addObject("postList", postList);
        mv.addObject("reportList", reportList);
        mv.addObject("selectCriteria1", selectCriteria1);
        mv.addObject("selectCriteria2", selectCriteria2);

        mv.setViewName("mypage/admin/editMemberInfo");

        return mv;

    }

    @GetMapping("/editTherapistInfo")
    public ModelAndView editTherapistInfo(HttpServletRequest request, ModelAndView mv, Model model,
                                          @RequestParam(name = "currentPage", defaultValue = "1") int pageNo) {
        log.info("[AdminPageController] ========");

        String userId = request.getParameter("userId");

        UserDTO therapist = adminPageService.therapistInfo(userId);
        model.addAttribute("therapist", therapist);

        int totalCommentCount = adminPageService.selectTotalCommentCount(userId);
        log.info("[MemberPageController] totalCommentCount : "+totalCommentCount);

        int limitPerPage = 5;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = Paging.getSelectCriteria(pageNo, totalCommentCount, limitPerPage, buttonAmount);

        log.info("[MemberPageController] selectCriteria : "+selectCriteria);

        List<TherapistComment> commentList = adminPageService.selectCommentList(selectCriteria, userId);

        log.info("[MemberPageController] commentList : "+commentList);

        mv.addObject("commentList", commentList);
        mv.addObject("selectCriteria", selectCriteria);

        mv.setViewName("mypage/admin/editTherapistInfo");
        return mv;
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
        log.info("[AdminPageController] ========");
        log.info("[AdminPageController] registComment Request : " + comment);

        try {
            adminPageService.registComment(comment);
            rttr.addFlashAttribute("cSuccessMessage", "답변 등록에 성공했습니다!");
        } catch(ModifyInfoException e) {
            rttr.addFlashAttribute("cErrorMessage", "답변 등록에 실패했습니다. 다시 시도해주세요.");
        }
        return "redirect:/admin/customerService";
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

    @RequestMapping("/confirmTherapist")
    @ResponseBody
    public void confirmTherapist(@RequestParam("userId") String userId) throws ModifyInfoException{
        adminPageService.confirmTherapist(userId);
    }

    @GetMapping("/reservPopup")
    public String reservPopup(@RequestParam(name = "userId") String userId, Model model) {
        BookInfo bookInfo = adminPageService.bookInfo(userId);
        model.addAttribute("bookInfo", bookInfo);
        return "mypage/therapist/reservPopup";
    }
}


//push용 주석
