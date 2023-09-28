package com.metavirtual.bloom.match.controller;

import com.metavirtual.bloom.common.paging.Paging;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.match.model.dto.TherapistInfoDTO;
import com.metavirtual.bloom.match.model.service.MatchService;
import com.metavirtual.bloom.psychometry.model.dto.MemberTestResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String matchingResultPage(HttpServletRequest request, Model model){
        String userId = String.valueOf(request.getParameter("userId"));

        System.out.println(userId);
        List<MemberTestResultDTO> findMemberTest = matchService.findMemberTest(userId);
        List<TherapistInfoDTO> therapyRecommend = matchService.therapyRecommend();

        model.addAttribute("therapyRecommend", therapyRecommend);
        System.out.println(findMemberTest + "1");

        if (!(findMemberTest == null || findMemberTest.isEmpty())) {
            therapyMatching(findMemberTest);
        }


        return "psychological/match/therapyRecommend";
    }
    public String therapyMatching(List<MemberTestResultDTO> findMemberTest){

        if (findMemberTest == null || findMemberTest.isEmpty()) {
            // 빈 리스트나 null일 경우 처리
            System.out.println("리스트가 비어 있거나 null입니다.");
        }

        MemberTestResultDTO maxScore = findMemberTest.get(0); // 첫 번째 요소를 초기 최대값으로 설정
        String maxKey = "depression"; // 초기 최대값의 키를 설정

        for (MemberTestResultDTO dto : findMemberTest) {
            if (dto.getDepressionTotalScore() > maxScore.getDepressionTotalScore()) {
                // 우울 테스트 점수가 현재 최대값보다 크면 최대값과 키를 업데이트
                maxScore = dto;
                maxKey = "depression";
            }
            if (dto.getAnxietyTotalScore() > maxScore.getAnxietyTotalScore()) {
                // 불안 테스트 점수가 현재 최대값보다 크면 최대값과 키를 업데이트
                maxScore = dto;
                maxKey = "anxiety";
            }
            if (dto.getBipolarTotalScore() > maxScore.getBipolarTotalScore()) {
                // 양극성 테스트 점수가 현재 최대값보다 크면 최대값과 키를 업데이트
                maxScore = dto;
                maxKey = "bipolar";
            }
            if (dto.getOcdTotalScore() > maxScore.getOcdTotalScore()) {
                // 강박성 테스트 점수가 현재 최대값보다 크면 최대값과 키를 업데이트
                maxScore = dto;
                maxKey = "ocd";
            }
        }

        // 최대값과 해당 항목의 키(필드) 출력
        System.out.println("최대값: " + maxScore);
        System.out.println("최대값의 키: " + maxKey);

        return "psychological/match/therapyRecommend";
    }
    @GetMapping("/introduceTherapy")
    public String introduceTherapyPage(){
        return "psychological/match/introduceTherapy";
    }
    /* 상담사 전체 조회 */
    @GetMapping(value = "/therapyList")
    public ModelAndView alltherapyList(@RequestParam(required = false) String D,
                                       @RequestParam(required = false) String A,
                                       @RequestParam(required = false) String B,
                                       @RequestParam(required = false) String O,
                                       @RequestParam(required = false) String R,
                                       @RequestParam(required = false) String searchValue,
                                       @RequestParam(value="currentPage", defaultValue = "1") int pageNo,
                                       ModelAndView mv){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("categoryD", D);
        searchMap.put("categoryA", A);
        searchMap.put("categoryB", B);
        searchMap.put("categoryO", O);
        searchMap.put("categoryR", R);
        searchMap.put("searchValue", searchValue);

        System.out.println("검색조건 : " + searchMap);

        int totalListCount = matchService.selectTotalCount(searchMap);

        System.out.println("총 게시물 수 : " + totalListCount);

        int limitPerPage = 12;
        int buttonAmount = 5;
        SelectCriteria selectCriteria;

        if(D != null && !"".equals(D)) {
            selectCriteria = Paging.getSelectCriteria(pageNo, totalListCount, limitPerPage, buttonAmount, D, searchValue);
        } else if (A != null && !"".equals(A)) {
            selectCriteria = Paging.getSelectCriteria(pageNo, totalListCount, limitPerPage, buttonAmount, A, searchValue);
        }else if (B != null && !"".equals(B)) {
            selectCriteria = Paging.getSelectCriteria(pageNo, totalListCount, limitPerPage, buttonAmount, B, searchValue);
        }else if (O != null && !"".equals(O)) {
            selectCriteria = Paging.getSelectCriteria(pageNo, totalListCount, limitPerPage, buttonAmount, O, searchValue);
        }else if (R != null && !"".equals(R)) {
            selectCriteria = Paging.getSelectCriteria(pageNo, totalListCount, limitPerPage, buttonAmount, R, searchValue);
        }
        else {
            selectCriteria = Paging.getSelectCriteria (pageNo, totalListCount, limitPerPage, buttonAmount);
        }

        List<TherapistInfoDTO> therapistInfo = matchService.findAllTherapist(selectCriteria);
        mv.addObject("therapistInfo", therapistInfo);
        mv.addObject("selectCriteria", selectCriteria);

        System.out.println(therapistInfo);
        mv.setViewName("psychological/match/therapyList");
        return mv;
    }
    /*@GetMapping("getScore")
    public String getTotalScore(@RequestParam("userId") String userId, Model model){
        List<TherapistInfoDTO> therapyRecommendList = matchService.getTotalScore(userId);
        System.out.println(therapyRecommendList);

        model.addAttribute("memberTestResult", therapyRecommendList);
        return "psychological/match/therapyRecommend";
    }*/
}
