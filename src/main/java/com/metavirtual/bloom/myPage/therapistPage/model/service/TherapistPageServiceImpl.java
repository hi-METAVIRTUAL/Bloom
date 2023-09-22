package com.metavirtual.bloom.myPage.therapistPage.model.service;

import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.therapistPage.model.dao.TherapistPageMapper;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ProfileFileDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ReservationDTO;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int selectReservationCount(){
        int result = mapper.selectReservationCount();
        return result;
    }

    @Override
    public List<ReservationDTO> selectReservationList(SelectCriteria selectCriteria){
        List<ReservationDTO> reservationList = mapper.selectReservationList(selectCriteria);
        return reservationList;
    }

    @Override
    public void confirmReservation(int bookingCode) throws ModifyInfoException{
        int result = mapper.confirmReservation(bookingCode);

        if(!(result>0)){
            throw new ModifyInfoException(("예약 승인 요청 실패"));
        }
    }

    @Override
    public void declineReservation(int bookingCode) throws ModifyInfoException{
        int result = mapper.declineReservation(bookingCode);

        if(!(result>0)){
            throw new ModifyInfoException(("예약 거절 요청 실패"));
        }
    }
}
