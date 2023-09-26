package com.metavirtual.bloom.psychometry.model.dto;

public class MemberTestResultDTO {

    private int resultCode;
    private String testDate;
    private String userId;
    private int depressionTotalScore;
    private int anxietyTotalScore;
    private int bipolarTotalScore;
    private int ocdTotalScore;


    public MemberTestResultDTO() {
    }

    public MemberTestResultDTO(int resultCode, String userId, String testDate, int depressionTotalScore, int anxietyTotalScore, int bipolarTotalScore, int ocdTotalScore) {
        this.resultCode = resultCode;
        this.userId = userId;
        this.testDate = testDate;
        this.depressionTotalScore = depressionTotalScore;
        this.anxietyTotalScore = anxietyTotalScore;
        this.bipolarTotalScore = bipolarTotalScore;
        this.ocdTotalScore = ocdTotalScore;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
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

    @Override
    public String toString() {
        return "MemberTestResultDTO{" +
                "resultCode=" + resultCode +
                ", userId='" + userId + '\'' +
                ", testDate='" + testDate + '\'' +
                ", depressionTotalScore=" + depressionTotalScore +
                ", anxietyTotalScore=" + anxietyTotalScore +
                ", bipolarTotalScore=" + bipolarTotalScore +
                ", ocdTotalScore=" + ocdTotalScore +
                '}';
    }
}
