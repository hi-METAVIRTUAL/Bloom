package com.metavirtual.bloom.booking.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookingMapper {
    int makeBooking(String therapistId, String userId, String selectedDateTime);
}
