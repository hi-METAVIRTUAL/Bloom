package com.metavirtual.bloom.psychological.match.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/match")
public class MatchController {
    @GetMapping("/match")
    public String matchingPage(){
        return "match/matchingPage";
    }
    @GetMapping("/therapyRecommend")
    public String matchingResultPage(){
        return "match/therapyRecommend";
    }
    @GetMapping("/introduceTherapy")
    public String introduceTherapyPage(){
        return "match/introduceTherapy";
    }
    @GetMapping("/therapyList")
    public String AlltherapyList(){
        return "match/therapyList";
    }
}
