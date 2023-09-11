package com.metavirtual.bloom.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @GetMapping("/qna")
    public String qna() {
        return "mypage/admin/qna";
    }


    @GetMapping("/editUserInfo")
    public String editUserInfo() {
        return "mypage/admin/editUserInfo";

    }

    @GetMapping("/editTherapistInfo")
    public String editTherapistInfo() {
        return "mypage/admin/editTherapistInfo";

    }
}
