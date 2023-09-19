package com.metavirtual.bloom.myPage.therapistPage.model.service;

import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

public interface TherapistPageService {

    public void modifyTherapistInfo(UserDTO user) throws ModifyInfoException;

    public void modifyTherapistProfile(TherapistDTO therapist) throws ModifyInfoException;

    public void modifyActivationStatus() throws ModifyInfoException;
}
