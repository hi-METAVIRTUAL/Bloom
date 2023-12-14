package com.metavirtual.bloom.myPage.memberPage.model.dto;

import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

import java.util.Date;

public class ReviewListDTO {
    private int bookingCode;
    private String name;
    private String bookingDate;
    private String reviewContent;
    private String therapistId;

    public ReviewListDTO() {
    }

    public ReviewListDTO(int bookingCode, String name, String bookingDate, String reviewContent, String therapistId) {
        this.bookingCode = bookingCode;
        this.name = name;
        this.bookingDate = bookingDate;
        this.reviewContent = reviewContent;
        this.therapistId = therapistId;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(String therapistId) {
        this.therapistId = therapistId;
    }

    @Override
    public String toString() {
        return "ReviewListDTO{" +
                "bookingCode=" + bookingCode +
                ", name='" + name + '\'' +
                ", bookingDate=" + bookingDate +
                ", reviewContent='" + reviewContent + '\'' +
                ", therapistId='" + therapistId + '\'' +
                '}';
    }
}
