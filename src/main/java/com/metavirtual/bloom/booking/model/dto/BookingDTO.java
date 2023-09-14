package com.metavirtual.bloom.booking.model.dto;

public class BookingDTO {
    private int bookingCode;
    private String bookingDate;
    private String memberId; // userId;
    private String therapistId; // userId;
    private String bookingStatus; // 예약상태 : 예약확정, 예약취소 선택버튼 요청을 전송

}
