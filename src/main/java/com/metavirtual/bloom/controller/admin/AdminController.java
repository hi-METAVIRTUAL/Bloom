package com.metavirtual.bloom.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/customerService")
    public String qna() {
        return "mypage/admin/customerService";
    }

    @GetMapping("/editUserInfo")
    public String editUserInfo() {
        return "mypage/admin/editUserInfo";
    }

    @GetMapping("/csAnswer")
    public String csAnswer(){
        return "mypage/admin/csAnswer";
    }
}
