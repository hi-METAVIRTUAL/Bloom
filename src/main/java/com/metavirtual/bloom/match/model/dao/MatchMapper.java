package com.metavirtual.bloom.match.model.dao;

import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.match.model.dto.TherapistInfoDTO;
import com.metavirtual.bloom.psychometry.model.dto.MemberTestResultDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MatchMapper {
    List<TherapistInfoDTO> findAllTherapist(SelectCriteria selectCriteria);

    List<MemberTestResultDTO> findMemberTest(String userId);

    List<TherapistInfoDTO> therapyRecommend();

    int selectTotalCount(Map<String, String> searchMap);

    String getDesiredField(String userId);
}
