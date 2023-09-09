package com.metavirtual.bloom.controller.psychological;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/psychological")
public class PsychologicalController {

    @GetMapping("/test")
    public String test(){ return "psychological/firstTest"; }
    @GetMapping("/start")
    public String strartTestPage(){ return "psychological/startTest"; }

    @GetMapping("/last")
    public String lastTestPage(){
        return "psychological/lastTest";
    }
    @GetMapping("/match")
    public String matchingPage(){
        return "psychological/matchingPage";
    }
    @GetMapping("/result")
    public String resultTestPage(){
        return "psychological/resultTest";
    }
    @GetMapping("/matchingResult")
    public String matchingResultPage(){
        return "psychological/matchingResult";
    }
}
