package com.metavirtual.bloom.myPage.therapistPage.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date bookingDate;

    private String memberId;

    public BookDTO() {
    }

    public BookDTO(Date bookingDate, String memberId) {
        this.bookingDate = bookingDate;
        this.memberId = memberId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookingDate=" + bookingDate +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
