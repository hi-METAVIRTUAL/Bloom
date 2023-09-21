package com.metavirtual.bloom.myPage.memberPage.model.dao;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;
import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.memberPage.model.dto.CommentListDTO;
import com.metavirtual.bloom.myPage.memberPage.model.dto.ReviewListDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberPageMapper {

    int modifyMemberInfo(MemberDTO member);

    int modifyUserInfo(UserDTO user);

    String selectMemberByNickname(String nickname);

    int selectTotalPostCount();

    int selectTotalCommentCount();

    int selectTotalReviewCount();

    List<BoardDTO> selectPostList(SelectCriteria selectCriteria);

    List<CommentListDTO> selectCommentList(SelectCriteria selectCriteria);

    List<ReviewListDTO> selectReviewList(SelectCriteria selectCriteria);

    int deleteMyPost(String boardCode);

    int deleteMyComment(int commentCode);

    int deleteMyReview(int bookingCode);

}
