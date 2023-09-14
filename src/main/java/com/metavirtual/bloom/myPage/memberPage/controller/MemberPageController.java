package com.metavirtual.bloom.myPage.memberPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberPageController {

    @GetMapping("/memberInfo")
    public String memberInfo (){
        return "mypage/member/memberInfo";
    }

    @GetMapping("/modifyMemberInfo")
    public String modifyMemberInfo(){
        return "mypage/member/modifyMemberInfo";
    }

//    @PostMapping("/modifyMemberInfo")
//    public String changeMemberInfo(@ModelAttribute MemberDTO member, User_DTO userInfo, HttpServletRequest request, HttpServletResponse reponse, RedirectAttributes rttr){
//        log.info("");
//        log.info("");
//        log.info("[MemberController] modifyMemberInfo ========");
//
//        user.setPwd(passwordEncoder.encode(user.getPwd()));
//        user.setEmail();
//        member.setNickname(member.nickname);
//        user.setPhone();
//
//        log.info("[MemberController] modifyMemberInfo request Member : " + member);
//
//        memberService.modifyMemberInfo(member);
//
//        return "redirect:/mypage/member/memberInfo";
//    }

    @GetMapping("/postList")
    public String postList(){
        return "mypage/member/postList";
    }
}
