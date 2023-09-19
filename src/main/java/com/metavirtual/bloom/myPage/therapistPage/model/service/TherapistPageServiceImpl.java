package com.metavirtual.bloom.myPage.therapistPage.model.service;

import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.myPage.therapistPage.model.dao.TherapistPageMapper;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class TherapistPageServiceImpl implements TherapistPageService{

    private final TherapistPageMapper mapper;
    public TherapistPageServiceImpl(TherapistPageMapper mapper){this.mapper = mapper;}

    @Override
    public void modifyTherapistInfo(UserDTO user) throws ModifyInfoException {
        int result = mapper.modifyTherapistInfo(user);

        if(!(result>0)){
            throw new ModifyInfoException(("❌상담사 정보 수정 실패❌"));
        }
    }

    @Override
    public void modifyTherapistProfile(TherapistDTO therapist) throws ModifyInfoException{
        int result = mapper.modifyTherapistProfile(therapist);

        if(!(result>0)){
            throw new ModifyInfoException(("❌상담사 프로필 수정 실패❌"));
        }
    }

    @Override
    public void modifyActivationStatus() throws ModifyInfoException{
        int result = mapper.modifyActivationStatus();

        if(!(result>0)){
            throw new ModifyInfoException(("❌상담활동 활성화 여부 변경 실패❌"));
        }
    }
}
