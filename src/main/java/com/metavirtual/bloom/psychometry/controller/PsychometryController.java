package com.metavirtual.bloom.psychometry.controller;

import com.metavirtual.bloom.psychometry.model.dto.TestQDTO;
import com.metavirtual.bloom.psychometry.model.service.PsychometryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "start",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<TestQDTO>  startTestPage() {

        List<TestQDTO> testQ = psychometryService.findContent();
        return testQ;
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
