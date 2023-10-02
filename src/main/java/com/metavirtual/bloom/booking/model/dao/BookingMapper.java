package com.metavirtual.bloom.booking.model.dao;


import org.apache.ibatis.annotations.Mapper;
import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BookingMapper {
    int makeBooking(String therapistId, String userId, String selectedDateTime);

    int selectTotalCount();

    List<ReviewDTO> findAllReview(SelectCriteria selectCriteria);

    int newReviewPosting(ReviewDTO newReview);
    int reviewDelete(ReviewDTO deleteReview);

}
