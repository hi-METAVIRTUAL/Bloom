package com.metavirtual.bloom.booking.model.service;

import com.metavirtual.bloom.booking.model.dao.BookingMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.common.exception.booking.ReviewDeleteException;
import com.metavirtual.bloom.common.exception.booking.ReviewInsertException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class BookingService {
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingService(BookingMapper bookingMapper) {
        this.bookingMapper = bookingMapper;
    }

    public void makeBooking(String therapistId, String userId, String selectedDateTime) {

        int makeBooking = bookingMapper.makeBooking(therapistId, userId, selectedDateTime);
        System.out.println(therapistId + " " + userId + " " + selectedDateTime);

        if (makeBooking > 0) {
            System.out.println("예약 성공!");
        } else {
            System.out.println("예약 실패");
        }
    }


    public int selectTotalCount() {

        int result = bookingMapper.selectTotalCount();

        return result;
    }

    /* 전체 후기 조회 */
    public List<ReviewDTO> findAllReview(SelectCriteria selectCriteria) {
        List<ReviewDTO> reviewList = bookingMapper.findAllReview(selectCriteria);
        return reviewList;
    }

    /* 후기 등록 */
    @Transactional
    public void newReviewPosting(ReviewDTO newReview) throws ReviewInsertException {
        int result = bookingMapper.newReviewPosting(newReview);
        if (!(result > 0)) {
            throw new ReviewInsertException("후기 등록에 실패하였습니다.");
        }
    }


    /* 후기 삭제 */
    @Transactional
    public void reviewDelete(ReviewDTO deleteReview) throws ReviewDeleteException {
        int result = bookingMapper.reviewDelete(deleteReview);

        if(!(result > 0)) {
            throw new ReviewDeleteException("후기 삭제에 실패하였습니다");
        }
    }
}

