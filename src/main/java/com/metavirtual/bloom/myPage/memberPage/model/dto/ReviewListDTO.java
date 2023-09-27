package com.metavirtual.bloom.myPage.memberPage.model.dto;

import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

public class ReviewListDTO {
    private int bookingCode;
    private String name;
    private int reviewScore;
    private String reviewContent;

    public ReviewListDTO() {
    }

    public ReviewListDTO(int bookingCode, String name, int reviewScore, String reviewContent) {
        this.bookingCode = bookingCode;
        this.name = name;
        this.reviewScore = reviewScore;
        this.reviewContent = reviewContent;
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

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    @Override
    public String toString() {
        return "ReviewListDTO{" +
                "bookingCode=" + bookingCode +
                ", name='" + name + '\'' +
                ", reviewScore=" + reviewScore +
                ", reviewContent='" + reviewContent + '\'' +
                '}';
    }
}
