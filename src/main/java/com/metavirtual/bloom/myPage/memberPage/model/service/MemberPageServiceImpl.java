package com.metavirtual.bloom.myPage.memberPage.model.service;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.common.exception.myPage.DeleteException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.memberPage.model.dao.MemberPageMapper;
import com.metavirtual.bloom.myPage.memberPage.model.dto.*;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberPageServiceImpl implements MemberPageService{

    private final MemberPageMapper mapper;

    public MemberPageServiceImpl(MemberPageMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public UserDTO userInfo(String userId) {
        UserDTO userInfo = mapper.userInfo(userId);
        return userInfo;
    }

    @Override
    public MemberBookingInfo memberBookingInfo(String name){
        MemberBookingInfo bookingInfo = mapper.memberBookingInfo(name);
        return bookingInfo;
    }

    @Override
    public MemberInfo memberInfo(String name){
        MemberInfo Info = mapper.memberInfo(name);
        return Info;
    }

    @Override
    public void modifyMemberInfo(MemberInfo member) throws ModifyInfoException {
        int result1 = mapper.modifyUserInfo(member);
        int result2 = mapper.modifyMemberInfo(member);

        if(!(result1>0 && result2>0)){
            throw new ModifyInfoException("❌회원 정보 수정 실패❌");
        }
    }

    @Override
    public boolean selectMemberByNickname(String nickname){
        int result = mapper.selectMemberByNickname(nickname);
        if(result>0){
            return false;
        } else {
            return true;
        }
    }

//    @Override
//    public MemberBoard memberAllBoard(String userId){
//        MemberBoard board = mapper.memberAllBoard(userId);
//        return board;
//    }

    @Override
    public int selectTotalPostCount(String userId){
        int result = mapper.selectTotalPostCount(userId);
        return result;
    }

    @Override
    public int selectTotalCommentCount(String userId){
        int result = mapper.selectTotalCommentCount(userId);
        return result;
    }

    @Override
    public int selectTotalReviewCount(String userId){
        int result = mapper.selectTotalReviewCount(userId);
        return result;
    }

    @Override
    public List<BoardDTO> selectPostList(SelectCriteria selectCriteria, String userId){
        List<BoardDTO> myPostList = mapper.selectPostList(selectCriteria, userId);
        return myPostList;
    }

    @Override
    public List<CommentListDTO> selectCommentList(SelectCriteria selectCriteria, String userId){
        List<CommentListDTO> myCommentList = mapper.selectCommentList(selectCriteria, userId);
        return myCommentList;
    }

    @Override
    public List<ReviewListDTO> selectReviewList(SelectCriteria selectCriteria, String userId){
        List<ReviewListDTO> myReviewList = mapper.selectReviewList(selectCriteria, userId);
        return myReviewList;
    }

    @Override
    public boolean deleteMyPost(int boardCode) throws DeleteException {
        int result = mapper.deleteMyPost(boardCode);

        if(result>0){
            return true;
        } else {
            throw new DeleteException("❌선택 게시글 삭제 실패❌");
        }
    }

    @Override
    public boolean deleteMyComment(int commentCode) throws DeleteException{
        int result = mapper.deleteMyComment(commentCode);

        if(result>0){
            return true;
        } else {
            throw new DeleteException("❌선택 댓글 삭제 실패❌");
        }
    }

    @Override
    public boolean deleteMyReview(int bookingCode) throws DeleteException{
        int result = mapper.deleteMyReview(bookingCode);

        if(result>0){
            return true;
        } else {
            throw new DeleteException("❌선택 후기 삭제 실패❌");
        }
    }
}

