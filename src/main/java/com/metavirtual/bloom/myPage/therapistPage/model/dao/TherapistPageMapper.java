package com.metavirtual.bloom.myPage.therapistPage.model.dao;

import com.metavirtual.bloom.myPage.therapistPage.model.dto.ProfileFileDTO;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TherapistPageMapper {

    int uploadPfImg(ProfileFileDTO profileFileDTO);

    int updatePfImg(ProfileFileDTO profileFileDTO);

    int modifyTherapistInfo(UserDTO user);

    int modifyTherapistProfile(TherapistDTO therapist);

    int modifyActivationStatus(char activationStatus);
}
