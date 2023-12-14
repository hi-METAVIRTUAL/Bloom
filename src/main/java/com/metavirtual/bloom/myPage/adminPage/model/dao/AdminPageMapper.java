package com.metavirtual.bloom.myPage.adminPage.model.dao;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.BoardReportDTO;
import com.metavirtual.bloom.common.paging.AdminCriteria;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dto.*;
import com.metavirtual.bloom.myPage.memberPage.model.dto.MemberInfo;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.BookInfo;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminPageMapper {
    int selectCsCount();

    List<CsListDTO> selectCsList(SelectCriteria selectCriteria);

    CsDetailDTO selectCsDetail(int boardCode);

    void registComment(AdminCommentDTO comment);

    int selectMemberCount(Map<String, String> searchMap);

    List<UserDTO> selectMemberList(AdminCriteria adminCriteria);

    int selectTherapistCount(Map<String, String> searchMap);

    List<UserDTO> selectTherapistList(AdminCriteria adminCriteria);

    int unregistMember(String userId, String unregistDate);

    List<UserDTO> selectunregistList(String userId);

    MemberInfo memberInfo(String userId);

    int selectTotalReportCount(String userId);

    int selectTotalPostCount(String userId);

    List<PostResult> selectPostList(SelectCriteria selectCriteria, String userId);

    List<MemberReport> selectReportList(SelectCriteria selectCriteria, String userId);

    UserDTO therapistInfo(String userId);

    int selectTotalCommentCount(String userId);

    List<TherapistComment> selectCommentList(SelectCriteria selectCriteria, String userId);

    int confirmTherapist(String userId);

    BookInfo bookInfo(String userId);
}
