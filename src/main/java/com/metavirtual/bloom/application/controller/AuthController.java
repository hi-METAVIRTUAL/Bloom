package com.metavirtual.bloom.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class AuthController {

    @GetMapping("/login")
    public void login() {}

    @GetMapping("/loginfail")
    public ModelAndView loginFail(@RequestParam String errorMessage, ModelAndView mv) {
        mv.addObject("message", errorMessage);
        mv.setViewName("app/loginfail");

        return mv;
    }

}
