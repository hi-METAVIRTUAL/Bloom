package com.metavirtual.bloom.myPage.memberPage.model.dao;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;
import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.memberPage.model.dto.*;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberPageMapper {

    MemberBookingInfo memberBookingInfo(String name);

    MemberInfo memberInfo(String name);

    int modifyMemberInfo(MemberInfo member);

    int modifyUserInfo(MemberInfo memberInfo);

    int selectMemberByNickname(String nickname);

//    MemberBoard memberAllBoard(String userId);

    int selectTotalPostCount(String userId);

    int selectTotalCommentCount(String userId);

    int selectTotalReviewCount(String userId);

    List<BoardDTO> selectPostList(SelectCriteria selectCriteria, String userId);

    List<CommentListDTO> selectCommentList(SelectCriteria selectCriteria, String userId);

    List<ReviewListDTO> selectReviewList(SelectCriteria selectCriteria, String userId);

    int deleteMyPost(int boardCode);

    int deleteMyComment(int commentCode);

    int deleteMyReview(int bookingCode);

}
