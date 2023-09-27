package com.metavirtual.bloom.myPage.adminPage.model.service;

import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.user.model.dto.UserDTO;

import java.util.List;

public interface AdminPageService {

    public int selectMemberCount();

    public List<UserDTO> selectMemberList(SelectCriteria selectCriteria);

    public int selectTherapistCount();

    public List<UserDTO> selectTherapistList(SelectCriteria selectCriteria);

    public List<UserDTO> unregistMember(UserDTO unregistMember) throws ModifyInfoException;

}
