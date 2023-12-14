package com.metavirtual.bloom.myPage.therapistPage.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String bookingDate;

    private String memberId;

    private String memberName;

    private int bookingCode;

    public BookDTO() {
    }

    public BookDTO(String bookingDate, String memberId, String memberName, int bookingCode) {
        this.bookingDate = bookingDate;
        this.memberId = memberId;
        this.memberName = memberName;
        this.bookingCode = bookingCode;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookingDate='" + bookingDate + '\'' +
                ", memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", bookingCode='" + bookingCode +
                '}';
    }
}
