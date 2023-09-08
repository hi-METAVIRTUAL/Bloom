package com.metavirtual.bloom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/test")
    public String test(){

        return "psychological/firstTest";
    }
    @GetMapping("/start")
    public String test1(){

        return "psychological/testStart";
    }

    @GetMapping("/last")
    public String lastPage(){
        return "psychological/lastTest";
    }
    @GetMapping("/match")
    public String matching(){
        return "psychological/match";
    }
}