package com.metavirtual.bloom.myPage.memberPage.model.service;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.common.exception.myPage.DeleteException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.memberPage.model.dao.MemberPageMapper;
import com.metavirtual.bloom.myPage.memberPage.model.dto.CommentListDTO;
import com.metavirtual.bloom.myPage.memberPage.model.dto.MemberBookingInfo;
import com.metavirtual.bloom.myPage.memberPage.model.dto.MemberInfo;
import com.metavirtual.bloom.myPage.memberPage.model.dto.ReviewListDTO;
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
    public void modifyMemberInfo(MemberInfo memberInfo) throws ModifyInfoException {
        int result1 = mapper.modifyUserInfo(memberInfo);
        int result2 = mapper.modifyMemberInfo(memberInfo);

        if(!(result1>0 && result2>0)){
            throw new ModifyInfoException("❌회원 정보 수정 실패❌");
        }
    }

    @Override
    public boolean selectMemberByNickname(String nickname){
        String result = mapper.selectMemberByNickname(nickname);
        return result != null? true : false;
    }

    @Override
    public int selectTotalPostCount(){
        int result = mapper.selectTotalPostCount();
        return result;
    }

    @Override
    public int selectTotalCommentCount(){
        int result = mapper.selectTotalCommentCount();
        return result;
    }

    @Override
    public int selectTotalReviewCount(){
        int result = mapper.selectTotalReviewCount();
        return result;
    }

    @Override
    public List<BoardDTO> selectPostList(SelectCriteria selectCriteria){
        List<BoardDTO> myPostList = mapper.selectPostList(selectCriteria);
        return myPostList;
    }

    @Override
    public List<CommentListDTO> selectCommentList(SelectCriteria selectCriteria){
        List<CommentListDTO> myCommentList = mapper.selectCommentList(selectCriteria);
        return myCommentList;
    }

    @Override
    public List<ReviewListDTO> selectReviewList(SelectCriteria selectCriteria){
        List<ReviewListDTO> myReviewList = mapper.selectReviewList(selectCriteria);
        return myReviewList;
    }

    @Override
    public void deleteMyPost(String boardCode) throws DeleteException {
        int result = mapper.deleteMyPost(boardCode);

        if(!(result>0)){
            throw new DeleteException("❌선택 게시글 삭제 실패❌");
        }
    }

    @Override
    public void deleteMyComment(int commentCode) throws DeleteException{
        int result = mapper.deleteMyComment(commentCode);

        if(!(result>0)){
            throw new DeleteException("❌선택 댓글 삭제 실패❌");
        }
    }

    @Override
    public void deleteMyReview(int bookingCode) throws DeleteException{
        int result = mapper.deleteMyReview(bookingCode);

        if(!(result>0)){
            throw new DeleteException("❌선택 후기 삭제 실패❌");
        }
    }
}

