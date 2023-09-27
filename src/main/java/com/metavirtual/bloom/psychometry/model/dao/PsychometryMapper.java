package com.metavirtual.bloom.psychometry.model.dao;

import com.metavirtual.bloom.psychometry.model.dto.TestQDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PsychometryMapper {

    List<TestQDTO> findContent(@Param("testCategory") String testCategory);

    int saveAnswers(int answer, String category, String userId);

    int hopeTherapist(MemberDTO member);

    int saveTotalScore(int totalD, int totalA, int totalB, int totalO, String userId);

    int getTotalScore(String userId);


}
