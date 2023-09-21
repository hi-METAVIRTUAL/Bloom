package com.metavirtual.bloom.myPage.memberPage.model.service;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.common.exception.myPage.DeleteException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.memberPage.model.dto.CommentListDTO;
import com.metavirtual.bloom.myPage.memberPage.model.dto.ReviewListDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface MemberPageService {

    public void modifyMemberInfo(MemberDTO member, UserDTO user) throws ModifyInfoException;

    public boolean selectMemberByNickname(String nickname);

    public int selectTotalPostCount();

    public int selectTotalCommentCount();

    public int selectTotalReviewCount();

    public List<BoardDTO> selectPostList(SelectCriteria selectCriteria);

    public List<CommentListDTO> selectCommentList(SelectCriteria selectCriteria);

    public List<ReviewListDTO> selectReviewList(SelectCriteria selectCriteria);

    public void deleteMyPost(String boardCode) throws DeleteException;

    public void deleteMyComment(int commentCode) throws DeleteException;

    public void deleteMyReview(int bookingCode) throws DeleteException;
}
