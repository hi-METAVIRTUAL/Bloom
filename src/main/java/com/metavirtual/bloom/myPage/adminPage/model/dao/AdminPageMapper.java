package com.metavirtual.bloom.myPage.adminPage.model.dao;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.common.paging.AdminCriteria;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dto.AdminCommentDTO;
import com.metavirtual.bloom.myPage.adminPage.model.dto.CsDetailDTO;
import com.metavirtual.bloom.myPage.adminPage.model.dto.CsListDTO;
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

}
