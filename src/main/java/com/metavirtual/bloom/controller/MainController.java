package com.metavirtual.bloom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public void gomain() {
    }

    @GetMapping("/")
    public String defaultLocation() {
        return "index";
    }

    @GetMapping("regist")
    public String regist(){
        return "regist/regist";
    }


}
