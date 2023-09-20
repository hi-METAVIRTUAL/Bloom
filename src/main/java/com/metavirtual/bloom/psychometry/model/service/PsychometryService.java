package com.metavirtual.bloom.psychometry.model.service;

import com.metavirtual.bloom.psychometry.model.dao.PsychometryMapper;
import com.metavirtual.bloom.psychometry.model.dto.TestQDTO;
import com.metavirtual.bloom.psychometry.model.dto.TestResultDTO;
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
    public List<TestResultDTO> saveAnswers(String answerScore, String testCategory) {
        psychometryMapper.saveAnswers(answerScore,testCategory);
        return null;
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
