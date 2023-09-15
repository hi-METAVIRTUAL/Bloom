package com.metavirtual.bloom.myPage.memberPage.model.service;

import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

public interface MemberPageService {

    public void modifyMemberInfo(MemberDTO member, UserDTO user);
}
