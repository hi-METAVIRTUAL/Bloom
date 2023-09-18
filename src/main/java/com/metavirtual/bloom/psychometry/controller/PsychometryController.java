package com.metavirtual.bloom.psychometry.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.metavirtual.bloom.psychometry.model.dto.TestQDTO;
import com.metavirtual.bloom.psychometry.model.service.PsychometryService;
import org.springframework.boot.Banner;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    @GetMapping(value = "start")
    public String startTestPage(Model model, HttpServletRequest request, HttpSession httpSession){


        String category = request.getParameter("category");

        List<TestQDTO> testQ = psychometryService.findContent(category);

        model.addAttribute("testQ", testQ);

        System.out.println(category);
        System.out.println(testQ + " 1");
        return "psychological/psychometry/startTest";
    }
    @GetMapping("last")
    public String lastTestPage(){
        return "psychological/psychometry/lastTest";
    }
    @GetMapping("loding")
    public String matchingPage(){
        return "psychological/psychometry/lodingPage";
    }
    @GetMapping("result")
    public String resultTestPage(){
        return "psychological/psychometry/resultTest";
    }
}
