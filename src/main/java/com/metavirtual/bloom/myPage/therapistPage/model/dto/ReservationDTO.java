package com.metavirtual.bloom.myPage.therapistPage.model.dto;

import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

public class ReservationDTO {
    BookingDTO bookingDTO;
    UserDTO userDTO;

    public ReservationDTO() {
    }

    public ReservationDTO(BookingDTO bookingDTO, UserDTO userDTO) {
        this.bookingDTO = bookingDTO;
        this.userDTO = userDTO;
    }

    public BookingDTO getBookingDTO() {
        return bookingDTO;
    }

    public void setBookingDTO(BookingDTO bookingDTO) {
        this.bookingDTO = bookingDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "bookingDTO=" + bookingDTO +
                ", userDTO=" + userDTO +
                '}';
    }
}
