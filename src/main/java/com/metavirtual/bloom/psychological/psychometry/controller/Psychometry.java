package com.metavirtual.bloom.psychological.psychometry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/psychological/psychometry")
public class Psychometry {
    @GetMapping("/test")
    public String test(){ return "psychological/psychometry/firstTest"; }
    @GetMapping("/start")
    public String strartTestPage(){ return "psychological/psychometry/startTest"; }

    @GetMapping("/last")
    public String lastTestPage(){
        return "psychological/psychometry/lastTest";
    }
    @GetMapping("/loding")
    public String matchingPage(){
        return "psychological/psychometry/lodingPage";
    }
    @GetMapping("/result")
    public String resultTestPage(){
        return "psychological/psychometry/resultTest";
    }
}
