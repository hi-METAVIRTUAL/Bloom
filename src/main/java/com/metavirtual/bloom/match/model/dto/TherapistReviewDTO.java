package com.metavirtual.bloom.match.model.dto;

import com.metavirtual.bloom.booking.model.dto.BookingDTO;

public class TherapistReviewDTO {

    private int bookingCode;
    private String postedDate;
    private int reviewScore;
    private String deleteDate;
    private String reviewContent;
    private BookingDTO therapistId;

    public TherapistReviewDTO() {
    }

    public TherapistReviewDTO(int bookingCode, String postedDate, int reviewScore, String deleteDate, String reviewContent, BookingDTO therapistId) {
        this.bookingCode = bookingCode;
        this.postedDate = postedDate;
        this.reviewScore = reviewScore;
        this.deleteDate = deleteDate;
        this.reviewContent = reviewContent;
        this.therapistId = therapistId;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public BookingDTO getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(BookingDTO therapistId) {
        this.therapistId = therapistId;
    }

    @Override
    public String toString() {
        return "TherapistReviewDTO{" +
                "bookingCode=" + bookingCode +
                ", postedDate='" + postedDate + '\'' +
                ", reviewScore=" + reviewScore +
                ", deleteDate='" + deleteDate + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                ", therapistId=" + therapistId +
                '}';
    }
}
