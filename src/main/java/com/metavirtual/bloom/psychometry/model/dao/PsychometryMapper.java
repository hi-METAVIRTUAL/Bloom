package com.metavirtual.bloom.psychometry.model.dao;

import com.metavirtual.bloom.psychometry.model.dto.TestQDTO;
import com.metavirtual.bloom.psychometry.model.dto.TestResultDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

@Mapper
public interface PsychometryMapper {

    List<TestQDTO> findContent(@Param("testCategory") String testCategory);

    int saveAnswers(int answer,String category);

    int hopeTherapist(MemberDTO member);

    int getTotalScore(String userId);

    int saveTotalScore(int totalD, int totalA, int totalB, int totalO, String userId);
}
