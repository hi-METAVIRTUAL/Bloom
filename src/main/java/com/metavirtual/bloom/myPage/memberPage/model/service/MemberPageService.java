package com.metavirtual.bloom.myPage.memberPage.model.service;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.common.exception.myPage.DeleteException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.memberPage.model.dto.*;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

import java.util.List;

public interface MemberPageService {

    public MemberBookingInfo memberBookingInfo(String name);

    public MemberInfo memberInfo(String name);

    public void modifyMemberInfo(MemberInfo member) throws ModifyInfoException;

    public boolean selectMemberByNickname(String nickname);

//    public MemberBoard memberAllBoard(String userId);

    public int selectTotalPostCount(String userId);

    public int selectTotalCommentCount(String userId);

    public int selectTotalReviewCount(String userId);

    public List<BoardDTO> selectPostList(SelectCriteria selectCriteria, String userId);

    public List<CommentListDTO> selectCommentList(SelectCriteria selectCriteria, String userId);

    public List<ReviewListDTO> selectReviewList(SelectCriteria selectCriteria, String userId);

    public void deleteMyPost(String boardCode) throws DeleteException;

    public void deleteMyComment(int commentCode) throws DeleteException;

    public void deleteMyReview(int bookingCode) throws DeleteException;
}
