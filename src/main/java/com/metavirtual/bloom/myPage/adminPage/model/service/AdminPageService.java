package com.metavirtual.bloom.myPage.adminPage.model.service;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.AdminCriteria;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dto.AdminCommentDTO;
import com.metavirtual.bloom.myPage.adminPage.model.dto.CsDetailDTO;
import com.metavirtual.bloom.myPage.adminPage.model.dto.CsListDTO;
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

}
