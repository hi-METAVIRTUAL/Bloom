package com.metavirtual.bloom.match.model.dao;

import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.match.model.dto.CategoryTotalScoreDTO;
import com.metavirtual.bloom.match.model.dto.TherapistInfoDTO;
import com.metavirtual.bloom.psychometry.model.dto.MemberTestResultDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MatchMapper {
    List<TherapistInfoDTO> findAllTherapist(SelectCriteria selectCriteria);

    List<CategoryTotalScoreDTO> getTotalSocre(String userId);

    int selectTotalCount(Map<String, String> searchMap);

    List<MemberDTO> getDesiredField(String userId);

    List<TherapistInfoDTO> recommendTherapist(String maxScoreField);

    List<TherapistInfoDTO> selectOneTherapist(String userId);

    List<ReviewDTO> findAllReview(String userId);
}
