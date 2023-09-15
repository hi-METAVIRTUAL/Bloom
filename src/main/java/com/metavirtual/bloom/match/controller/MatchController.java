package com.metavirtual.bloom.match.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/psychological/match")
public class MatchController {
    @GetMapping("/match")
    public String matchingPage(){
        return "psychological/match/matchingPage";
    }
    @GetMapping("/therapyRecommend")
    public String matchingResultPage(){
        return "psychological/match/therapyRecommend";
    }
    @GetMapping("/introduceTherapy")
    public String introduceTherapyPage(){
        return "psychological/match/introduceTherapy";
    }
    @GetMapping("/therapyList")
    public String AlltherapyList(){
        return "psychological/match/therapyList";
    }
}
