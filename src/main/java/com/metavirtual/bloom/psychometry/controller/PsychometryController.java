package com.metavirtual.bloom.psychometry.controller;

import com.metavirtual.bloom.psychometry.model.dto.TestQDTO;
import com.metavirtual.bloom.psychometry.model.service.PsychometryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("psychological/psychometry")
public class PsychometryController {


    private final PsychometryService psychometryService;

    public PsychometryController(PsychometryService psychometryService) {
        this.psychometryService = psychometryService;
    }

    @GetMapping("first")
    public String test(){ return "psychological/psychometry/firstTest"; }
    @GetMapping("start")
    public String startTestPage(Model model){

        List<TestQDTO> testQ = psychometryService.findContent();

        model.addAttribute("testQ", testQ);

        return "psychological/psychometry/startTest";
    }

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
