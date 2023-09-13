package com.metavirtual.bloom.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/profile1")
    public String profile1 (){
        return "mypage/member/profile1";
    }

    @GetMapping("/profile2")
    public String profile2(){
        return "mypage/member/profile2";
    }

    @GetMapping("/infoSetting")
    public String infoSetting(){
        return "mypage/member/infoSetting";
    }
}