package com.metavirtual.bloom.myPage.therapistPage.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

public class BookInfo {
    private int bookingCode;
    private String bookingDate;
    private String name;
    private String memberId;
    private String phone;
    private int depressionTotalScore;
    private int anxietyTotalScore;
    private int bipolarTotalScore;
    private int ocdTotalScore;
    private String etcContent;
    private char relationCK;

    public BookInfo() {
    }

    public BookInfo(int bookingCode, String bookingDate, String name, String memberId, String phone, int depressionTotalScore, int anxietyTotalScore, int bipolarTotalScore, int ocdTotalScore, String etcContent, char relationCK) {
        this.bookingCode = bookingCode;
        this.bookingDate = bookingDate;
        this.name = name;
        this.memberId = memberId;
        this.phone = phone;
        this.depressionTotalScore = depressionTotalScore;
        this.anxietyTotalScore = anxietyTotalScore;
        this.bipolarTotalScore = bipolarTotalScore;
        this.ocdTotalScore = ocdTotalScore;
        this.etcContent = etcContent;
        this.relationCK = relationCK;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDepressionTotalScore() {
        return depressionTotalScore;
    }

    public void setDepressionTotalScore(int depressionTotalScore) {
        this.depressionTotalScore = depressionTotalScore;
    }

    public int getAnxietyTotalScore() {
        return anxietyTotalScore;
    }

    public void setAnxietyTotalScore(int anxietyTotalScore) {
        this.anxietyTotalScore = anxietyTotalScore;
    }

    public int getBipolarTotalScore() {
        return bipolarTotalScore;
    }

    public void setBipolarTotalScore(int bipolarTotalScore) {
        this.bipolarTotalScore = bipolarTotalScore;
    }

    public int getOcdTotalScore() {
        return ocdTotalScore;
    }

    public void setOcdTotalScore(int ocdTotalScore) {
        this.ocdTotalScore = ocdTotalScore;
    }

    public String getEtcContent() {
        return etcContent;
    }

    public void setEtcContent(String etcContent) {
        this.etcContent = etcContent;
    }

    public char getRelationCK() {
        return relationCK;
    }

    public void setRelationCK(char relationCK) {
        this.relationCK = relationCK;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "bookingCode=" + bookingCode +
                ", bookingDate='" + bookingDate + '\'' +
                ", name='" + name + '\'' +
                ", memberId='" + memberId + '\'' +
                ", phone='" + phone + '\'' +
                ", depressionTotalScore=" + depressionTotalScore +
                ", anxietyTotalScore=" + anxietyTotalScore +
                ", bipolarTotalScore=" + bipolarTotalScore +
                ", ocdTotalScore=" + ocdTotalScore +
                ", etcContent='" + etcContent + '\'' +
                ", relationCK=" + relationCK +
                '}';
    }
}
