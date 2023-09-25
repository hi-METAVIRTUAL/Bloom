package com.metavirtual.bloom.psychometry.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metavirtual.bloom.psychometry.model.dto.TestQDTO;
import com.metavirtual.bloom.psychometry.model.dto.TestResultDTO;
import com.metavirtual.bloom.psychometry.model.service.PsychometryService;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
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
import java.util.HashMap;
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

    @GetMapping("start")
    public String startTestPage(){return "psychological/psychometry/startTest";}
    @GetMapping(value = "startAjax",produces = "application/json; charset=UTF-8")
    public ModelAndView getTestPage(ModelAndView mv, HttpServletResponse response,
                                    @RequestParam(value = "testCategory") String testCategory) throws JsonProcessingException{
        response.setContentType("application/json; charset=UTF-8");
        List<TestQDTO> testQ = psychometryService.findContent(testCategory);
        ObjectMapper mapper = new ObjectMapper();
        mv.addObject("testQ", mapper.writeValueAsString(testQ));
        mv.setViewName("jsonView");
        return mv;
    }
    @PostMapping(value = "saveAnswers", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<String> SaveAnswers(@RequestBody Map<String, Object> dataToSend,
                                              HttpSession session) throws JsonProcessingException {
        int totalD = 0;
        int totalA = 0;
        int totalB = 0;
        int totalO = 0;
        String userId=(String) session.getAttribute("userId");
        List<String> categories = (List<String>) dataToSend.get("categories");
        List<String> answers = (List<String>) dataToSend.get("answers");
        for (int i = 0; i < categories.size(); i++){
            String category = categories.get(i);
            int answer = Integer.parseInt(answers.get(i));
            System.out.println(category+"카테");
            if ("D".equals(category)) {
                totalD += answer;
                System.out.println(totalD + "토탈1");
            } else if ("A".equals(category)) {
                totalA += answer;
            } else if ("B".equals(category)) {
                totalB += answer;
            } else if ("O".equals(category)) {
                totalO += answer;
            }
            psychometryService.saveAnswers(answer,category);

            System.out.println(totalD + "토탈");
        }
        psychometryService.saveTotalScore(totalD,totalA,totalB,totalO,userId);


        System.out.println(categories);
        System.out.println(answers);
        // categories 및 answers 데이터를 원하는 방식으로 처리
        // 응답을 반환하거나 추가 처리 수행
        Map<String, String> response = new HashMap<>();
        response.put("message", "데이터 전송 성공");

        return ResponseEntity.ok(new ObjectMapper().writeValueAsString(response));
    }
    @GetMapping("last")
    public String lastTestPage(){
        return "psychological/psychometry/lastTest";
    }
    @PostMapping("/loding")
    public String matchingPage(MemberDTO member, RedirectAttributes rttr){

        psychometryService.hopeTherapist(member);
        rttr.addFlashAttribute("successMessage", "신규 메뉴 등록에 성공 했습니다.");

        return "psychological/psychometry/lodingPage";
    }
    @GetMapping("result")
    public String resultTestPage(HttpSession session){
        String userId=(String) session.getAttribute("userId");
        int totalScore = psychometryService.getTotalScore(userId);

        return "psychological/psychometry/resultTest";
    }
}




