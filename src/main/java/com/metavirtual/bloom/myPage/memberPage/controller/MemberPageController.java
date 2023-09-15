package com.metavirtual.bloom.myPage.memberPage.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/member")
public class MemberPageController {

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

//    @PostMapping("/infoSetting")
//    public String modifyMemberInfo(@ModelAttribute MemberDTO member, UserInfo_DTO userInfo, HttpServletRequest request, HttpServletResponse reponse, RedirectAttributes rttr){
//
//
//
//        userInfo.setPwd(passwordEncoder.encode(userInfo.getPwd()));
//        userInfo.setEmail();
//        member.setNickname(nickname);
//        userInfo.setPhone();
//
//        log.info("[MemberPageController] modifyMemberInfo request Member : " + member);
//        memberPageService.modifyMemberInfo(member, userInfo);
//    }

    @GetMapping("/postList")
    public String postList(){
        return "mypage/member/postList";
    }
}
