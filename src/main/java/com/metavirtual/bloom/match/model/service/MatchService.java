package com.metavirtual.bloom.match.model.service;

import com.metavirtual.bloom.match.model.dao.MatchMapper;
import com.metavirtual.bloom.match.model.dto.TherapistInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchMapper matchMapper;

    @Autowired
    private MatchService (MatchMapper matchMapper){
        this.matchMapper = matchMapper;
    }

    public List<TherapistInfoDTO> findAllTherapist() {

        return matchMapper.findAllTherapist();
    }
}
