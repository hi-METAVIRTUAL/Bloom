package com.metavirtual.bloom.myPage.therapistPage.model.service;

import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.BookDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ProfileFileDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ReservationDTO;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

import java.util.List;

public interface TherapistPageService {

    public void uploadProfileImg(ProfileFileDTO profileFileDTO) throws ModifyInfoException;

    public void modifyTherapistInfo(UserDTO user) throws ModifyInfoException;

    public void modifyTherapistProfile(TherapistDTO therapist) throws ModifyInfoException;

    public void modifyActivationStatus(char activationStatus) throws ModifyInfoException;

    public int selectReservationCount();

    public List<ReservationDTO> selectReservationList(SelectCriteria selectCriteria);

    public void confirmReservation(int bookingCode) throws ModifyInfoException;

    public void declineReservation(int bookingCode) throws ModifyInfoException;

    public List<BookDTO> getBooking() throws Exception;
}
