package com.metavirtual.bloom.controller.RegistController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/regist")
public class RegistController {

    @GetMapping("/category")
    public String regist(){
        return "regist/registCategory";
    }

    @GetMapping("/memberRegist")
    public String regularRegist(){
        return "regist/memberRegist";
    }

    @GetMapping("/memberRegistSuccess")
    public String regularRegistSuccess() {
        return "regist/memberRegistSuccess"; }

    @GetMapping("/therapistRegist")
    public String therapistRegist(){
        return "regist/therapistRegist";
    }

    @GetMapping("/therapistRegist2")
    public String therapistRegist2(){
        return "regist/therapistRegist2";
    }

    @GetMapping("/therapistRegistSuccess")
    public String therapistRegistSuccess() { return "regist/therapistRegistSuccess"; }


    @GetMapping("/login")
    public String login() { return "regist/login"; }

    @GetMapping("/findId")
    public String findId() { return "regist/findId"; }

    @GetMapping("/findPassword")
    public String findPassword() {
        return "regist/findPassword";
    }

    @GetMapping("/verificationIdSent")
    public String idSentToEmail() { return "regist/verificationIdsent"; }

    @GetMapping("verificationPasswordSent")
    public String passwordSentToEmail() { return "regist/verificationPasswordSent"; }
}
/**/