package com.metavirtual.bloom.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/profile1")
    public String profile1 (){
        return "mypage/user/profile1";
    }

    @GetMapping("/profile2")
    public String profile2(){
        return "mypage/user/profile2";
    }

    @GetMapping("/infoSetting")
    public String infoSetting(){
        return "mypage/user/infoSetting";
    }
}
