package com.metavirtual.bloom.match.model.dao;

import com.metavirtual.bloom.match.model.dto.TherapistInfoDTO;
import com.metavirtual.bloom.psychometry.model.dto.MemberTestResultDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MatchMapper {
    List<TherapistInfoDTO> findAllTherapist();

    List<MemberTestResultDTO> getTotalScore(String userId);
}
