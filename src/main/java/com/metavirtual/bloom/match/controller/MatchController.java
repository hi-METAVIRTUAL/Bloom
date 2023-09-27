package com.metavirtual.bloom.match.controller;

import com.metavirtual.bloom.match.model.dto.TherapistInfoDTO;
import com.metavirtual.bloom.match.model.service.MatchService;
import com.metavirtual.bloom.psychometry.model.dto.MemberTestResultDTO;
import com.metavirtual.bloom.psychometry.model.dto.TestResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("therapyRecommend")
    public String matchingResultPage(String userId, Model model){
        List<TherapistInfoDTO> therapyRecommendList = matchService.getTotalScore(userId);

        model.addAttribute("therapyRecommendList", therapyRecommendList);
        return "psychological/match/therapyRecommend";
    }
    @PostMapping("therapyRecommend")
    public String therapyRecommendPage(Model model){
        List<TherapistInfoDTO> therapyRecommend = matchService.therapyRecommend();
        model.addAttribute("therapyRecommend", therapyRecommend);
        System.out.println(therapyRecommend);

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

        System.out.println(therapistInfo);

        return "psychological/match/therapyList";
    }
    /*@GetMapping("getScore")
    public String getTotalScore(@RequestParam("userId") String userId, Model model){
        List<TherapistInfoDTO> therapyRecommendList = matchService.getTotalScore(userId);
        System.out.println(therapyRecommendList);

        model.addAttribute("memberTestResult", therapyRecommendList);
        return "psychological/match/therapyRecommend";
    }*/
}
