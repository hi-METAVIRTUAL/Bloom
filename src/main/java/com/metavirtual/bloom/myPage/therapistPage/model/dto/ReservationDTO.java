package com.metavirtual.bloom.myPage.therapistPage.model.dto;

import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

public class ReservationDTO {
    private int bookingCode;
    private String memberName;
    private char memberGender;
    private String bookingDate;
    private String memberPhone;

    public ReservationDTO() {
    }

    public ReservationDTO(int bookingCode, String memberName, char memberGender, String bookingDate, String memberPhone) {
        this.bookingCode = bookingCode;
        this.memberName = memberName;
        this.memberGender = memberGender;
        this.bookingDate = bookingDate;
        this.memberPhone = memberPhone;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public char getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(char memberGender) {
        this.memberGender = memberGender;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "bookingCode=" + bookingCode +
                ", memberName='" + memberName + '\'' +
                ", memberGender=" + memberGender +
                ", bookingDate='" + bookingDate + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                '}';
    }
}
