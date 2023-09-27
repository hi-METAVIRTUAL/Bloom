package com.metavirtual.bloom.myPage.memberPage.model.dto;

public class MemberBookingInfo {
    private String name;
    private String bookingDate;
    private String phone;
    private String bookingStatus;

    public MemberBookingInfo() {
    }

    public MemberBookingInfo(String name, String bookingDate, String phone, String bookingStatus) {
        this.name = name;
        this.bookingDate = bookingDate;
        this.phone = phone;
        this.bookingStatus = bookingStatus;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {
        return "MemberBookingInfo{" +
                "name='" + name + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", phone='" + phone + '\'' +
                ", bookingStatus='" + bookingStatus + '\'' +
                '}';
    }
}
