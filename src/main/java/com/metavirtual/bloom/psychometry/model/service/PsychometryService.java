package com.metavirtual.bloom.psychometry.model.service;

import com.metavirtual.bloom.psychometry.model.dao.PsychometryMapper;
import com.metavirtual.bloom.psychometry.model.dto.TestQDTO;
import com.metavirtual.bloom.psychometry.model.dto.TestResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PsychometryService {

    private final PsychometryMapper psychometryMapper;

    @Autowired
    public PsychometryService (PsychometryMapper psychometryMapper){
        this.psychometryMapper = psychometryMapper;
    }

    public List<TestQDTO> findContent() {
        return psychometryMapper.findContent();
    }

    public TestQDTO findContentByCategory(String index) {
        return psychometryMapper.getQuestionByIndex(index);

    }
}
