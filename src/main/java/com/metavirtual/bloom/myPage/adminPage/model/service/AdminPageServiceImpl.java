package com.metavirtual.bloom.myPage.adminPage.model.service;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.BoardReportDTO;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.AdminCriteria;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dao.AdminPageMapper;
import com.metavirtual.bloom.myPage.adminPage.model.dto.*;
import com.metavirtual.bloom.myPage.memberPage.model.dto.MemberInfo;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.BookInfo;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class AdminPageServiceImpl implements AdminPageService{

    private final AdminPageMapper mapper;

    public AdminPageServiceImpl(AdminPageMapper mapper){this.mapper = mapper;}

    @Override
    public int selectCsCount() {
        int result = mapper.selectCsCount();
        return result;
    }

    @Override
    public List<CsListDTO> selectCsList(SelectCriteria selectCriteria) {
        List<CsListDTO> selectCsList = mapper.selectCsList(selectCriteria);
        return selectCsList;
    }

    @Override
    @Transactional
    public CsDetailDTO selectCsDetail(int boardCode){
        CsDetailDTO csDetail =  mapper.selectCsDetail(boardCode);
        return csDetail;
    }

    @Override
    public void registComment(AdminCommentDTO comment)throws ModifyInfoException{
        mapper.registComment(comment);
    }

    @Override
    public int selectMemberCount(Map<String, String> searchMap) {
        int result = mapper.selectMemberCount(searchMap);
        return result;
    }

    @Override
    public List<UserDTO> selectMemberList(AdminCriteria adminCriteria) {
        List<UserDTO> selectMemberList = mapper.selectMemberList(adminCriteria);
        return selectMemberList;
    }

    @Override
    public int selectTherapistCount(Map<String, String> searchMap) {
        int result = mapper.selectTherapistCount(searchMap);
        return result;
    }

    @Override
    public List<UserDTO> selectTherapistList(AdminCriteria adminCriteria) {
        List<UserDTO> selectTherapistList = mapper.selectTherapistList(adminCriteria);
        return selectTherapistList;
    }

    @Override
    public List<UserDTO> unregistMember(UserDTO unregistMember) throws  ModifyInfoException{
        List<UserDTO> unregistList = null;

        int result = mapper.unregistMember(unregistMember.getUserId(), unregistMember.getUnregistDate());

        if(!(result>0)){
            throw new ModifyInfoException(("❌회원 탈퇴 처리 실패❌"));
        } else {
            unregistList = mapper.selectunregistList(unregistMember.getUserId());
        }
        return unregistList;
    }

    @Override
    public MemberInfo memberInfo(String userId) {
        MemberInfo Info = mapper.memberInfo(userId);
        return Info;
    }

    @Override
    public int selectTotalReportCount(String userId) {
        int result = mapper.selectTotalReportCount(userId);
        return result;
    }

    @Override
    public int selectTotalPostCount(String userId) {
        int result = mapper.selectTotalPostCount(userId);
        return result;
    }

    @Override
    public List<PostResult> selectPostList(SelectCriteria selectCriteria, String userId) {
        List<PostResult> postList = mapper.selectPostList(selectCriteria, userId);
        return postList;
    }

    @Override
    public List<MemberReport> selectReportList(SelectCriteria selectCriteria, String userId) {
        List<MemberReport> reportList = mapper.selectReportList(selectCriteria, userId);
        return reportList;
    }

    @Override
    public UserDTO therapistInfo(String userId) {
        UserDTO Info = mapper.therapistInfo(userId);
        return Info;
    }

    @Override
    public int selectTotalCommentCount(String userId) {
        int result = mapper.selectTotalCommentCount(userId);
        return result;
    }

    @Override
    public List<TherapistComment> selectCommentList(SelectCriteria selectCriteria, String userId) {
        List<TherapistComment> commentList = mapper.selectCommentList(selectCriteria, userId);
        return commentList;
    }

    @Override
    public void confirmTherapist(String userId) throws ModifyInfoException{
        int result = mapper.confirmTherapist(userId);

        if(!(result>0)){
            throw new ModifyInfoException(("예약 거절 요청 실패"));
        }
    }

    @Override
    public BookInfo bookInfo(String userId){
        BookInfo bookInfo = mapper.bookInfo(userId);
        return bookInfo;
    }
}
