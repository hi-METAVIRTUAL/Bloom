package com.metavirtual.bloom.myPage.adminPage.model.dao;

import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminPageMapper {

    int selectMemberCount();

    List<UserDTO> selectMemberList(SelectCriteria selectCriteria);

    int selectTherapistCount();

    List<UserDTO> selectTherapistList(SelectCriteria selectCriteria);
}
