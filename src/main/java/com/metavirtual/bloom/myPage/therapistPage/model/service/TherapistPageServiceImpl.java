package com.metavirtual.bloom.myPage.therapistPage.model.service;

import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.myPage.therapistPage.model.dao.TherapistPageMapper;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ProfileFileDTO;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class TherapistPageServiceImpl implements TherapistPageService{

    private final TherapistPageMapper mapper;
    public TherapistPageServiceImpl(TherapistPageMapper mapper){this.mapper = mapper;}

    @Override
    public void uploadProfileImg(ProfileFileDTO profileFileDTO) throws ModifyInfoException{
        int result;

        if(profileFileDTO.getFileNumber() == 0){
            result = mapper.uploadPfImg(profileFileDTO);
        } else {
            result = mapper.updatePfImg(profileFileDTO);
        }
        if(!(result>0)){
            throw new ModifyInfoException("❌프로필 사진 업로드 실패❌");
        }
    }

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
    public void modifyActivationStatus(char activationStatus) throws ModifyInfoException{
        int result = mapper.modifyActivationStatus(activationStatus);

        if(!(result>0)){
            throw new ModifyInfoException(("❌상담활동 활성화 여부 변경 실패❌"));
        }
    }
}
