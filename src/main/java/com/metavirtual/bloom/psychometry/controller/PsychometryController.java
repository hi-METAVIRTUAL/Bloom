package com.metavirtual.bloom.psychometry.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metavirtual.bloom.psychometry.model.dto.TestQDTO;
import com.metavirtual.bloom.psychometry.model.dto.TestResultDTO;
import com.metavirtual.bloom.psychometry.model.service.PsychometryService;
import org.springframework.boot.Banner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public String startTestPage(Model model, HttpServletRequest request, HttpSession httpSession){


        String category = request.getParameter("category");
        List<TestQDTO> testQ = psychometryService.findContent(category);
        System.out.println(category);
        model.addAttribute("testQ", testQ);

        return "psychological/psychometry/startTest";
    }
    @GetMapping(value = "startAjax",produces = "application/json; charset=UTF-8")
    public ModelAndView getTestPage(ModelAndView mv, HttpServletResponse response,HttpServletRequest request) throws JsonProcessingException{
        /*response.setContentType("application/json; charset=UTF-8");*/

        String category = request.getParameter("category");
        List<TestQDTO> testQ = psychometryService.findContent(category);
        System.out.println(category);

        ObjectMapper mapper = new ObjectMapper();
        mv.addObject("testQ", mapper.writeValueAsString(testQ));
        mv.setViewName("jsonView");
        System.out.println("여긴 지나갔지?");
        return mv;
    }

    @PostMapping(value = "/saveAnswers", produces = "application/json; charset=UTF-8", consumes = "application/json")
    @ResponseBody
    public String SaveAnswers(@RequestBody List<TestResultDTO> answerData) {
        psychometryService.saveAnswers(answerData);
        return "저장 완료";
    }
    @GetMapping("/saveAnswers")
    public String goRegister() {
        return "psychological/psychometry/lastTest";
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


 /* @PostMapping(value = "saveAnswers", produces = "application/json; charset=UTF-8", consumes = "application/json")
    public ResponseEntity<String>  SaveAnswers(@RequestBody Map<String, Map<String, String>> answerData)  {

        System.out.println("왔나?1 " + answerData);
        // formData에서 필요한 데이터를 추출하여 사용


        Map<String, String> categoryAAnswers = answerData.get("categoryA");
        Map<String, String> categoryBAnswers = answerData.get("categoryB");
        Map<String, String> categoryOAnswers = answerData.get("categoryO");


        if (categoryAAnswers != null && !categoryAAnswers.isEmpty()) {
            // 카테고리 A에 대한 답변 저장 로직
            psychometryService.saveAnswers(categoryAAnswers, "A");
        }
        if (categoryBAnswers != null && !categoryBAnswers.isEmpty()) {
            // 카테고리 B에 대한 답변 저장 로직
            psychometryService.saveAnswers(categoryBAnswers, "B");
        }
        if (categoryOAnswers != null && !categoryOAnswers.isEmpty()) {
            // 카테고리 O에 대한 답변 저장 로직
            psychometryService.saveAnswers(categoryOAnswers, "O");
        }


        return ResponseEntity.ok("저장 완료");
       *//* String categoryD = answers.get("D");
        String categoryA = answers.get("A");
        String categoryB = answers.get("B");
        String categoryO = answers.get("O");*//*
    }*/