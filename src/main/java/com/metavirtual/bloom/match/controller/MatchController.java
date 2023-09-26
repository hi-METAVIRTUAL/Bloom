package com.metavirtual.bloom.match.controller;

import com.metavirtual.bloom.match.model.dto.TherapistInfoDTO;
import com.metavirtual.bloom.match.model.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/psychological/match")
public class MatchController {

    private final MatchService matchService;
    public MatchController(MatchService matchService){
    this.matchService = matchService;
    }


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
    public String AlltherapyList(Model model){

        List<TherapistInfoDTO> therapistInfo = matchService.findAllTherapist();
        model.addAttribute("therapistInfo", therapistInfo);


        return "psychological/match/therapyList";
    }
}
