package com.metavirtual.bloom.psychometry.model.service;

import com.metavirtual.bloom.psychometry.model.dao.PsychometryMapper;
import com.metavirtual.bloom.psychometry.model.dto.TestQDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void saveAnswers(int answer, String category, String userId) {

            psychometryMapper.saveAnswers(answer,category,userId);
    }
    public void saveTotalScore(int totalD, int totalA, int totalB, int totalO, String userId) {
        psychometryMapper.saveTotalScore(totalD,totalA,totalB,totalO,userId);
    }

    @Transactional
    public void hopeTherapist(MemberDTO member) {

        psychometryMapper.hopeTherapist(member);
    }

    public int getTotalScore(String userId) {
        return psychometryMapper.getTotalScore(userId);
    }

}