package com.metavirtual.bloom.myPage.memberPage.model.dto;

import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

public class ReviewListDTO {
    private ReviewDTO reviewDTO;
    private UserDTO userDTO;

    public ReviewListDTO() {
    }

    public ReviewListDTO(ReviewDTO reviewDTO, UserDTO userDTO) {
        this.reviewDTO = reviewDTO;
        this.userDTO = userDTO;
    }

    public ReviewDTO getReviewDTO() {
        return reviewDTO;
    }

    public void setReviewDTO(ReviewDTO reviewDTO) {
        this.reviewDTO = reviewDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "ReviewListDTO{" +
                "reviewDTO=" + reviewDTO +
                ", userDTO=" + userDTO +
                '}';
    }
}
