package com.metavirtual.bloom.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @GetMapping("/customerService")
    public String customerService() {
        return "mypage/admin/customerService";
    }


    @GetMapping("/editUserInfo")
    public String editUserInfo() {
        return "mypage/admin/editUserInfo";

    }

    @GetMapping("/editTherapistInfo")
    public String editTherapistInfo() {
        return "mypage/admin/editTherapistInfo";

    }

    @GetMapping("/csAnswer")
    public String csAnswer(){
        return "mypage/admin/csAnswer";
    }

    @GetMapping("/inquireUser")
    public String inquireUser(){
        return "mypage/admin/inquireUser";}

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
}


//push용 주석
