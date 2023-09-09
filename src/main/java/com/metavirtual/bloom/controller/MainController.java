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
        return "regist/registCategory";
    }


    @GetMapping("regularRegist")
    public String regularRegist(){
        return "regist/regularRegist";
    }

    @GetMapping("therapistRegist")
    public String therapistRegist(){
        return "regist/therapistRegist";
    }

    @GetMapping("test")
    public String test() {
        return null;
    }


    @GetMapping("review")
    public String review() {
        return "reviewboard/reviewmain";
    }

}

