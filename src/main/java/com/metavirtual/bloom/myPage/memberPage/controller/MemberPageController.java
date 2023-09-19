/*
package com.metavirtual.bloom.myPage.memberPage.controller;

import com.metavirtual.bloom.myPage.memberPage.model.service.MemberPageServiceImpl;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/member")
public class MemberPageController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final PasswordEncoder passwordEncoder;
    private final MemberPageServiceImpl memberPageService;
    public MemberPageController(PasswordEncoder passwordEncoder, MemberPageServiceImpl memberPageService){
        this.passwordEncoder = passwordEncoder;
        this.memberPageService = memberPageService;
    }


    @GetMapping("/memberInfo")
    public String memberInfo (){
        return "mypage/member/memberInfo";
    }

    @GetMapping("/modifyMemberInfo")
    public String modifyMemberInfo(){
        return "mypage/member/modifyMemberInfo";
    }

    @PostMapping("/modifyMemberInfo")
    public String changeMemberInfo(@ModelAttribute MemberDTO member, UserDTO user, HttpServletRequest request, HttpServletResponse reponse, RedirectAttributes rttr){
        log.info("");
        log.info("");
        log.info("[MemberController] modifyMemberInfo ========");

        user.setPwd(passwordEncoder.encode(user.getPwd()));
        user.setEmail(user.getEmail());
        member.setNickname(member.getNickname());
        user.setPhone(user.getPhone());

        log.info("[MemberController] modifyMemberInfo request Member, user : " + member + user);

        memberPageService.modifyMemberInfo(member, user);

        return "redirect:/mypage/member/memberInfo";
    }

    @GetMapping("/postList")
    public String postList(){
        return "mypage/member/postList";
    }

    @DeleteMapping("/deleteMYPost")
    public String deleteMyPost(){


        return null;
    }

    @DeleteMapping("/deleteMyComment")
    public String deletMyComment(){


        return null;
    }
}
*/
