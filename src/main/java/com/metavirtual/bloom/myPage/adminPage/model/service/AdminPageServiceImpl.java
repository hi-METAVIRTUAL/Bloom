package com.metavirtual.bloom.myPage.adminPage.model.service;

import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dao.AdminPageMapper;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPageServiceImpl implements AdminPageService{

    private final AdminPageMapper mapper;

    public AdminPageServiceImpl(AdminPageMapper mapper){this.mapper = mapper;}

    @Override
    public int selectMemberCount() {
        int result = mapper.selectMemberCount();
        return result;
    }

    @Override
    public List<UserDTO> selectMemberList(SelectCriteria selectCriteria) {
        List<UserDTO> selectMemberList = mapper.selectMemberList(selectCriteria);
        return selectMemberList;
    }

    @Override
    public int selectTherapistCount() {
        int result = mapper.selectTherapistCount();
        return result;
    }

    @Override
    public List<UserDTO> selectTherapistList(SelectCriteria selectCriteria) {
        List<UserDTO> selectTherapistList = mapper.selectTherapistList(selectCriteria);
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
}
