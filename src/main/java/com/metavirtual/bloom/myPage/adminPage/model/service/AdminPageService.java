package com.metavirtual.bloom.myPage.adminPage.model.service;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.BoardReportDTO;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.AdminCriteria;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dto.*;
import com.metavirtual.bloom.myPage.memberPage.model.dto.MemberInfo;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.BookInfo;
import com.metavirtual.bloom.user.model.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface AdminPageService {

    public int selectCsCount();

    public List<CsListDTO> selectCsList(SelectCriteria selectCriteria);

    public CsDetailDTO selectCsDetail(int boardCode);

    public void registComment(AdminCommentDTO comment)throws ModifyInfoException;

    public int selectMemberCount(Map<String, String> searchMap);

    public List<UserDTO> selectMemberList(AdminCriteria adminCriteria);

    public int selectTherapistCount(Map<String, String> searchMap);

    public List<UserDTO> selectTherapistList(AdminCriteria adminCriteria);

    public List<UserDTO> unregistMember(UserDTO unregistMember) throws ModifyInfoException;

    public MemberInfo memberInfo(String userId);

    public int selectTotalReportCount(String userId);

    public int selectTotalPostCount(String userId);

    public List<PostResult> selectPostList(SelectCriteria selectCriteria, String userId);

    public List<MemberReport> selectReportList(SelectCriteria selectCriteria, String userId);

    public UserDTO therapistInfo(String userId);

    public int selectTotalCommentCount(String userId);

    public List<TherapistComment> selectCommentList(SelectCriteria selectCriteria, String userId);

    public void confirmTherapist(String userId) throws ModifyInfoException;

    public BookInfo bookInfo(String userId);
}
