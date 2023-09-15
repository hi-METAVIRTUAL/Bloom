package com.metavirtual.bloom.user.controller;

import com.metavirtual.bloom.user.model.dto.UserDTO;
import com.metavirtual.bloom.user.model.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/member")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final PasswordEncoder passwordEncoder;
    private final UserServiceImpl userService;

    public UserController(PasswordEncoder passwordEncoder, UserServiceImpl userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/category")
    public String regist(){
        return "member/registCategory";
    }

    @GetMapping("/memberRegist")
    public String regularRegist(){
        return "member/memberRegist";
    }

    @PostMapping("/memberRegist")
    public String registMember(@ModelAttribute UserDTO user, HttpServletRequest request, RedirectAttributes rttr) {
        return null;
    }

    @GetMapping("/memberRegistSuccess")
    public String regularRegistSuccess() {
        return "member/memberRegistSuccess"; }

    @GetMapping("/therapistRegist")
    public String therapistRegist(){
        return "member/therapistRegist";
    }

    @GetMapping("/therapistRegist2")
    public String therapistRegist2(){
        return "member/therapistRegist2";
    }

    @GetMapping("/therapistRegistSuccess")
    public String therapistRegistSuccess() { return "member/therapistRegistSuccess"; }


    @GetMapping("/login")
    public String login() { return "member/login"; }

    @GetMapping("/findId")
    public String findId() { return "member/findId"; }

    @GetMapping("/findPassword")
    public String findPassword() {
        return "member/findPassword";
    }

    @GetMapping("/verificationIdSent")
    public String idSentToEmail() { return "member/verificationIdsent"; }

    @GetMapping("verificationPasswordSent")
    public String passwordSentToEmail() { return "member/verificationPasswordSent"; }
}
/**/