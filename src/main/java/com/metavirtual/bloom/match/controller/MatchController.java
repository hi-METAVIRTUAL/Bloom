package com.metavirtual.bloom.match.controller;

import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.common.paging.Paging;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.match.model.dto.CategoryTotalScoreDTO;
import com.metavirtual.bloom.common.paging.MatchCriteria;
import com.metavirtual.bloom.match.model.dto.TherapistInfoDTO;
import com.metavirtual.bloom.match.model.service.MatchService;
import com.metavirtual.bloom.psychometry.model.dto.MemberTestResultDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
    public ModelAndView matchingResultPage(HttpServletRequest request,ModelAndView mv){
        String userId = String.valueOf(request.getParameter("userId"));


        /* 희망 상담사 성별 */
        List<MemberDTO> desiredField = matchService.getDesiredField(userId);
        List<CategoryTotalScoreDTO> categoryTotalScore = matchService.getTotalSocre(userId);


        System.out.println(categoryTotalScore);
        categoryTotalScore.sort(Comparator.comparingInt(CategoryTotalScoreDTO::getDepressionTotalScore));
        System.out.println(categoryTotalScore);
        int maxDepressionTotalScore = Integer.MIN_VALUE;

        // 최대값을 저장할 필드의 이름을 저장하는 변수
        String maxDepressionTotalScoreField = null;

        int maxScore = Integer.MIN_VALUE; // 초기값을 가장 작은 정수로 설정
        String maxScoreField = null; // 최대값을 가진 필드 이름을 저장할 변수

        for (CategoryTotalScoreDTO dto : categoryTotalScore) {
            // CategoryTotalScoreDTO 객체의 각 필드 값을 비교
            if (dto.getDepressionTotalScore() > maxScore) {
                maxScore = dto.getDepressionTotalScore();
                maxScoreField = "DEPRESSION_CK";
            }
            if (dto.getAnxietyTotalScore() > maxScore) {
                maxScore = dto.getAnxietyTotalScore();
                maxScoreField = "ANXIETY_CK";
            }
            if (dto.getBipolarTotalScore() > maxScore) {
                maxScore = dto.getBipolarTotalScore();
                maxScoreField = "BIPOLAR_CK";
            }
            if (dto.getOcdTotalScore() > maxScore) {
                maxScore = dto.getOcdTotalScore();
                maxScoreField = "OCD_CK";
            }
        }

        System.out.println("최대값: " + maxScore);
        System.out.println("최대값을 가진 키(필드 이름): " + maxScoreField);

        List<TherapistInfoDTO> recomendTherapist = matchService.recommendTherapist(maxScoreField);
        System.out.println(recomendTherapist + " 추천");

        mv.addObject("recomendTherapist", recomendTherapist);

        mv.setViewName("psychological/match/therapyRecommend");

        return mv;

    }

/*    @GetMapping("/introduceTherapy/{id}")
    public String introduceTherapyPage(@PathVariable("id") String userId, Model model) {
        model.addAttribute("userId", userId);

        System.out.println("match controller : " + userId);
        return "psychological/match/introduceTherapy";
    }*/

    @GetMapping("/introduceTherapy")
    public ModelAndView introduceTherapyPage(@RequestParam("userId") String userId, ModelAndView mv){
        List<TherapistInfoDTO> selectOneTherapist = matchService.selectOneTherapist(userId);


        mv.addObject("selectOneTherapist", selectOneTherapist);
        mv.setViewName("psychological/match/introduceTherapy");

        List<ReviewDTO> reviewList = matchService.findAllReview(userId);
        System.out.println("MatchingController: " + reviewList);
        mv.addObject("reviewList", reviewList);


        return mv;
    }
      
    /* 상담사 전체 조회 */
    @GetMapping(value = "/therapyList")
    public ModelAndView alltherapyList(@RequestParam(value = "d", defaultValue = " ") char d,
                                       @RequestParam(value = "a", defaultValue = " ") char a,
                                       @RequestParam(value = "b", defaultValue = " ") char b,
                                       @RequestParam(value = "o", defaultValue = " ") char o,
                                       @RequestParam(value = "r", defaultValue = " ") char r,
                                       @RequestParam(required = false) String searchValue,
                                       @RequestParam(value="currentPage", defaultValue = "1") int pageNo,
                                       ModelAndView mv){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("d", String.valueOf(d));
        searchMap.put("a", String.valueOf(a));
        searchMap.put("b", String.valueOf(b));
        searchMap.put("o", String.valueOf(o));
        searchMap.put("r", String.valueOf(r));
        searchMap.put("searchValue", searchValue);

        System.out.println("검색조건 : " + searchMap);

        int totalListCount = matchService.selectTotalCount(searchMap);

        System.out.println("총 게시물 수 : " + totalListCount);

        int limitPerPage = 12;
        int buttonAmount = 5;
        MatchCriteria matchCriteria;

        if( d != ' ' || a != ' ' || b != ' ' || o != ' ' || r != ' ' || searchValue != null) {
            matchCriteria = Paging.getMatchCriteria(pageNo, totalListCount, limitPerPage, buttonAmount, d, a, b, o, r, searchValue);
        } else {
            matchCriteria = Paging.getMatchCriteria(pageNo, totalListCount, limitPerPage, buttonAmount);
        }

        List<TherapistInfoDTO> therapistInfo = matchService.findAllTherapist(matchCriteria);
        mv.addObject("therapistInfo", therapistInfo);
        mv.addObject("selectCriteria", matchCriteria);

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

    /*
    * @GetMapping("therapyRecommend")
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
    }*/
}
