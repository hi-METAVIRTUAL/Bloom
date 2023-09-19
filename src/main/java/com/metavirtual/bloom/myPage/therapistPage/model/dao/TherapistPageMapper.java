package com.metavirtual.bloom.myPage.therapistPage.model.dao;

import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TherapistPageMapper {

    int modifyTherapistInfo(UserDTO user);

    int modifyTherapistProfile(TherapistDTO therapist);

    int modifyActivationStatus();
}
