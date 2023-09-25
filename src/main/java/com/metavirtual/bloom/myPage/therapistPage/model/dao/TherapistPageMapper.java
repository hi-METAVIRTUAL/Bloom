package com.metavirtual.bloom.myPage.therapistPage.model.dao;

import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.BookDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ProfileFileDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ReservationDTO;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TherapistPageMapper {

    int uploadPfImg(ProfileFileDTO profileFileDTO);

    int updatePfImg(ProfileFileDTO profileFileDTO);

    int modifyTherapistInfo(UserDTO user);

    int modifyTherapistProfile(TherapistDTO therapist);

    int modifyActivationStatus(char activationStatus);

    int selectReservationCount();

    List<ReservationDTO> selectReservationList(SelectCriteria selectCriteria);

    int confirmReservation(int bookingCode);

    int declineReservation(int bookingCode);

    List<BookDTO> getBooking();
}
