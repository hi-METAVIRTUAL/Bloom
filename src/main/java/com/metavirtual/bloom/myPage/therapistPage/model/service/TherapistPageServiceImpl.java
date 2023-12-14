package com.metavirtual.bloom.myPage.therapistPage.model.service;

import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.therapistPage.model.dao.TherapistPageMapper;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.BookDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.BookInfo;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ProfileFileDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ReservationDTO;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TherapistPageServiceImpl implements TherapistPageService{

    private final TherapistPageMapper mapper;
    public TherapistPageServiceImpl(TherapistPageMapper mapper, SqlSession sqlSession){
        this.mapper = mapper;
    }

    @Override
    public UserDTO userInfo(String userId) {
        UserDTO userInfo = mapper.userInfo(userId);
        return userInfo;
    }

    @Override
    public TherapistDTO therapistInfo(String userId) {
        TherapistDTO therapistInfo = mapper.therapistInfo(userId);
        return therapistInfo;
    }

    @Override
    public ProfileFileDTO profileInfo(String userId) {
        ProfileFileDTO profileInfo = mapper.profileInfo(userId);
        return profileInfo;
    }

    @Override
    public void uploadProfileImg(ProfileFileDTO uploadInfo) throws ModifyInfoException{
        int result = mapper.uploadPfImg(uploadInfo);

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
    public boolean modifyActivationStatus(char activationStatus, String userId) throws ModifyInfoException{
        int result = mapper.modifyActivationStatus(activationStatus, userId);

        if(result>0) {
            return true;
        } else {
            throw new ModifyInfoException(("❌상담활동 활성화 여부 변경 실패❌"));
        }
    }

    @Override
    public int selectReservationCount(String userId){
        int result = mapper.selectReservationCount(userId);
        return result;
    }

    @Override
    public List<ReservationDTO> selectReservationList(SelectCriteria selectCriteria, String userId){
        List<ReservationDTO> reservationList = mapper.selectReservationList(selectCriteria, userId);
        return reservationList;
    }

    @Override
    public List<ReservationDTO> selectConfirmList(String userId){
        List<ReservationDTO> selectConfirmList = mapper.selectConfirmList(userId);
        return selectConfirmList;
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

    @Override
    public List<BookDTO> bookingList(String userId) throws Exception {
        List<BookDTO> book = null;
        book = mapper.bookingList(userId);

        return book;
    }

    @Override
    public BookInfo bookInfo(int bookingCode){
        BookInfo bookInfo = mapper.bookInfo(bookingCode);
        return bookInfo;
    }
}
