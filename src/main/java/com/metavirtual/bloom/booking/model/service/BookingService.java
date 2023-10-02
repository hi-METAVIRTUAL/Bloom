package com.metavirtual.bloom.booking.model.service;

import com.metavirtual.bloom.booking.model.dao.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingService(BookingMapper bookingMapper) {
        this.bookingMapper = bookingMapper;
    }

    public void makeBooking(String therapistId, String userId, String selectedDateTime) {

       int makeBooking = bookingMapper.makeBooking(therapistId, userId, selectedDateTime);
        System.out.println(therapistId + " " + userId + " " + selectedDateTime);

       if(makeBooking > 0){
           System.out.println("예약 성공!");
       } else {
           System.out.println("예약 실패");
       }
    }
}
