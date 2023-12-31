package com.metavirtual.bloom.match.model.service;


import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.common.paging.MatchCriteria;
import com.metavirtual.bloom.match.model.dao.MatchMapper;
import com.metavirtual.bloom.match.model.dto.CategoryTotalScoreDTO;
import com.metavirtual.bloom.match.model.dto.TherapistInfoDTO;
import com.metavirtual.bloom.psychometry.model.dto.MemberTestResultDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MatchService {

    private final MatchMapper matchMapper;

    @Autowired
    private MatchService (MatchMapper matchMapper){
        this.matchMapper = matchMapper;
    }

    public int selectTotalCount(Map<String, String> searchMap) {

        int result = matchMapper.selectTotalCount(searchMap);
        return result;
    }
    public List<TherapistInfoDTO> findAllTherapist(MatchCriteria matchCriteria) {
        List<TherapistInfoDTO> therapistList= matchMapper.findAllTherapist(matchCriteria);
        return therapistList;
    }

    public List<MemberDTO> getDesiredField(String userId) {


        return matchMapper.getDesiredField(userId);
    }

    public List<CategoryTotalScoreDTO> getTotalSocre(String userId) {
        List<CategoryTotalScoreDTO> getTotalSocre = matchMapper.getTotalSocre(userId);

        return getTotalSocre;
    }

    public List<TherapistInfoDTO> recommendTherapist(String maxScoreField, List<MemberDTO> desiredField) {
        List<TherapistInfoDTO> recommendTherapist = matchMapper.recommendTherapist(maxScoreField, desiredField);
        return recommendTherapist;
    }

    public List<TherapistInfoDTO> selectOneTherapist(String userId) {
        List<TherapistInfoDTO> selectOneTherapist = matchMapper.selectOneTherapist(userId);
        return selectOneTherapist;
    }

    public List<ReviewDTO> findAllReview(String userId) {
        List<ReviewDTO> findAllReview = matchMapper.findAllReview(userId);
        return findAllReview;
    }
}

/*
    public List<TherapistInfoDTO> therapyRecommend() {
        return  matchMapper.therapyRecommend();
    }

* int maxScore = Integer.MIN_VALUE;
        String maxCategory = null;

        for (MemberTestResultDTO result : memberTestResults) {
            int totalScore = calculateTotalScore(result);
            if (totalScore > maxScore) {
                maxScore = totalScore;
                maxCategory = getCategoryWithMaxScore(result);
            }
            System.out.println(result+ "리절트");
        }

        // 2. 가장 높은 총합을 가지고 있는 카테고리를 찾았으므로, 해당 카테고리와 상담사의 강점 카테고리를 비교하여 추천
        List<TherapistInfoDTO> therapists = matchMapper.findAllTherapist();
        List<TherapistInfoDTO> recommendedTherapists = new ArrayList<>();

        for (TherapistInfoDTO therapist : therapists) {
            if (isCategoryMatch(therapist, maxCategory)) {
                recommendedTherapists.add(therapist);
            }
            System.out.println(therapist + "테라피");

        }

        return recommendedTherapists;
    }

    private int calculateTotalScore(MemberTestResultDTO result) {
        // 각 카테고리별 점수를 계산하는 로직 구현
        int depressionTotalScore = result.getDepressionTotalScore();
        int anxietyTotalScore = result.getAnxietyTotalScore();
        int bipolarTotalScore = result.getBipolarTotalScore();
        int ocdTotalScore = result.getOcdTotalScore();

        return depressionTotalScore + anxietyTotalScore + bipolarTotalScore + ocdTotalScore;
    }

    private String getCategoryWithMaxScore(MemberTestResultDTO result) {
        // 각 카테고리별 총합 중 가장 큰 카테고리를 반환하는 로직 구현
        // 예를 들어, 가장 큰 카테고리가 "depression"이면 "depression"을 반환
        // 카테고리가 정확히 무엇인지는 데이터 모델 및 로직에 따라 다를 수 있음
        // 이 예시에서는 최대값을 구하는 로직만 표현
        int depressionTotalScore = result.getDepressionTotalScore();
        int anxietyTotalScore = result.getAnxietyTotalScore();
        int bipolarTotalScore = result.getBipolarTotalScore();
        int ocdTotalScore = result.getOcdTotalScore();

        int maxScore = Math.max(depressionTotalScore, Math.max(anxietyTotalScore, Math.max(bipolarTotalScore, ocdTotalScore)));

        if (maxScore == depressionTotalScore) {
            return "depression";
        } else if (maxScore == anxietyTotalScore) {
            return "anxiety";
        } else if (maxScore == bipolarTotalScore) {
            return "bipolar";
        } else if (maxScore == ocdTotalScore) {
            return "ocd";
        }

        return null; // 예외 처리 필요
       }
         private boolean isCategoryMatch(TherapistInfoDTO therapist, String maxCategory) {
        // 상담사의 강점 카테고리와 최대 카테고리를 비교하여 일치 여부 확인
        // maxCategory와 therapist의 카테고
        return true;
    }
    * */


/*
*  List<MemberTestResultDTO> memberTestResult = matchMapper.getTotalScore(userId);
        int maxScore = Integer.MIN_VALUE;
        String maxColumnName = null;

        for (MemberTestResultDTO result : memberTestResult) {
            int depressionTotalScore = result.getDepressionTotalScore();
            int anxietyTotalScore = result.getAnxietyTotalScore();
            int bipolarTotalScore = result.getBipolarTotalScore();
            int ocdTotalScore = result.getOcdTotalScore();

            int maxColumnValue = Math.max(depressionTotalScore, Math.max(anxietyTotalScore, Math.max(bipolarTotalScore, ocdTotalScore)));

            if (maxColumnValue > maxScore) {
                maxScore = maxColumnValue;

                if (maxColumnValue == depressionTotalScore) {
                    maxColumnName = "depression";
                } else if (maxColumnValue == anxietyTotalScore) {
                    maxColumnName = "anxiety";
                } else if (maxColumnValue == bipolarTotalScore) {
                    maxColumnName = "bipolar";
                } else if (maxColumnValue == ocdTotalScore) {
                    maxColumnName = "ocd";
                }
            }
        }
        System.out.println("가장 큰 값: " + maxScore);
        System.out.println("가장 큰 값의 칼럼 이름: " + maxColumnName);

        System.out.println(memberTestResult);



        return memberTestResult;*/
