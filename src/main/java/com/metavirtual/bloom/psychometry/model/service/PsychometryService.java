package com.metavirtual.bloom.psychometry.model.service;

import com.metavirtual.bloom.psychometry.model.dao.PsychometryMapper;
import com.metavirtual.bloom.psychometry.model.dto.TestQDTO;
import com.metavirtual.bloom.psychometry.model.dto.TestResultDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class PsychometryService {

    private final PsychometryMapper psychometryMapper;

    @Autowired
    public PsychometryService (PsychometryMapper psychometryMapper){
        this.psychometryMapper = psychometryMapper;
    }

    public List<TestQDTO> findContent(String testCategory) {
        return psychometryMapper.findContent(testCategory);
    }



    @Transactional
    public void saveAnswers(int answer,String category) {

            psychometryMapper.saveAnswers(answer,category);
    }
    public void saveTotalScore(int totalD, int totalA, int totalB, int totalO, String userId) {
        psychometryMapper.saveTotalScore(totalD,totalA,totalB,totalO,userId);
    }

    @Transactional
    public void hopeTherapist(MemberDTO member) {

        System.out.println(member+ "서비스");
        psychometryMapper.hopeTherapist(member);
        System.out.println(member);
    }

    public int getTotalScore(String userId) {
        int total = psychometryMapper.getTotalScore(userId);
        return total;
    }



}


/*public void saveAnswers(Map<String, String> answers, String category) {
        for (Map.Entry<String, String> entry : answers.entrySet()) {
            String testCategory = entry.getKey();
            String answerScore = entry.getValue();

            // 데이터베이스에 저장 로직 구현
            // testCategory와 answerScore를 이용하여 TestResults 테이블에 저장
            psychometryMapper.saveAnswers(category, testCategory, answerScore);
        }
    }*/
