package com.metavirtual.bloom.myPage.therapistPage.model.service;

import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.BookDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.BookInfo;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ProfileFileDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ReservationDTO;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

import java.util.List;

public interface TherapistPageService {
    public UserDTO userInfo(String userId);
    public TherapistDTO therapistInfo(String userId);
    public ProfileFileDTO profileInfo(String userId);

    public void uploadProfileImg(ProfileFileDTO uploadInfo) throws ModifyInfoException;

    public void modifyTherapistInfo(UserDTO user) throws ModifyInfoException;

    public void modifyTherapistProfile(TherapistDTO therapist) throws ModifyInfoException;

    public boolean modifyActivationStatus(char activationStatus, String userId) throws ModifyInfoException;

    public int selectReservationCount(String UserId);

    public List<ReservationDTO> selectReservationList(SelectCriteria selectCriteria, String userId);

    public List<ReservationDTO> selectConfirmList(String userId);

    public void confirmReservation(int bookingCode) throws ModifyInfoException;

    public void declineReservation(int bookingCode) throws ModifyInfoException;

    public List<BookDTO> bookingList(String userId) throws Exception;

    public BookInfo bookInfo(int bookingCode);
}
