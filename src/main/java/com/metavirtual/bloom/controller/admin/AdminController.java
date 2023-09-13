package com.metavirtual.bloom.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String adminPage() {
        return "mypage/admin/adminPage";
    }

    @GetMapping("/customerService")
    public String customerService() {
        return "mypage/admin/customerService";
    }


    @GetMapping("/editMemberInfo")
    public String editMemberInfo() {
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
    public String inquireMember(){
        return "mypage/admin/inquireMember";}

    @GetMapping("/inquireTherapist")
    public String inquireTherapist(){
        return "mypage/admin/inquireTherapist";}

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
