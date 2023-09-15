package com.metavirtual.bloom.myPage.memberPage.model.dao;

import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberPageMapper {

    int modifyMemberInfo(MemberDTO member, UserDTO user);

}
