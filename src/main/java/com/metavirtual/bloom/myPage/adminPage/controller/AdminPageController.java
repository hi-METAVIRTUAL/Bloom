package com.metavirtual.bloom.myPage.adminPage.controller;

import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.Paging;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.service.AdminPageServiceImpl;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ReservationDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;

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
    public String customerService() {
        return "mypage/admin/customerService";
    }


    @GetMapping("/editMemberInfo")
    public String editMemberInfo(HttpServletRequest request, Model model) {
        log.info("");
        log.info("[AdminPageController] ========");
        String userId = String.valueOf(request.getParameter("userId"));


        return "mypage/admin/editMemberInfo";

    }

    @GetMapping("/editTherapistInfo")
    public String editTherapistInfo() {
        return "mypage/admin/editTherapistInfo";

    }

    @GetMapping("/csAnswer")
    public String csAnswer(){
        return "mypage/admin/csAnswer";
    }

    @GetMapping("/inquireMember")
    public ModelAndView inquireMember(HttpServletRequest request, @RequestParam(value = "currentPage"
                                        , defaultValue = "1") int pageNo, ModelAndView mv){
        log.info("");
        log.info("");
        log.info("[AdminPageController] ========");


        int totalMemberCount = adminPageService.selectMemberCount();
        log.info("[AdminPageController] totalMemberCount" + totalMemberCount);

        int limitPerPage = 10;
        int buttonAmount = 10;

        SelectCriteria selectCriteria = Paging.getSelectCriteria(pageNo, totalMemberCount, limitPerPage, buttonAmount);

        log.info("[AdminPageController] selectCriteria : "+selectCriteria);

        List<UserDTO> memberList = adminPageService.selectMemberList(selectCriteria);

        log.info("[AdminPageController] memberList : "+memberList);

        mv.addObject("memberList", memberList);
        mv.addObject("selectCriteria", selectCriteria);
        log.info("[TherapistController] SelectCriteria : "+selectCriteria);
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
    public ModelAndView inquireTherapist(HttpServletRequest request, @RequestParam(value = "currentPage"
                                    , defaultValue = "1") int pageNo, ModelAndView mv){
        log.info("");
        log.info("");
        log.info("[AdminPageController] ========");


        int totalTherapistCount = adminPageService.selectTherapistCount();
        log.info("[AdminPageController] totalTherapistCount" + totalTherapistCount);

        int limitPerPage = 10;
        int buttonAmount = 10;

        SelectCriteria selectCriteria = Paging.getSelectCriteria(pageNo, totalTherapistCount, limitPerPage, buttonAmount);

        log.info("[AdminPageController] selectCriteria : "+selectCriteria);

        List<UserDTO> therapistList = adminPageService.selectTherapistList(selectCriteria);

        log.info("[AdminPageController] therapistList : "+therapistList);

        mv.addObject("therapistList", therapistList);
        mv.addObject("selectCriteria", selectCriteria);
        log.info("[TherapistController] SelectCriteria : "+selectCriteria);
        mv.setViewName("mypage/admin/inquireTherapist");

        log.info("[AdminPageController] ========");

        return mv;
    }

    @GetMapping("/reservePopup")
    public String reservePopup() {
        return "mypage/admin/reservePopup";
    }

    @GetMapping("/inqTheraProfile")
    public String inqTheraProfile(){
        return "mypage/admin/inqTheraProfile";
    }

    @GetMapping("/therapistProfile")
    public String therapistProfile(){
        return "mypage/admin/therapistProfile";
    }

    @GetMapping("/report")
    public String report(){
        return "mypage/admin/report";
    }
}


//push용 주석
