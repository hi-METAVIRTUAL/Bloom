package com.metavirtual.bloom.psychometry.model.dto;

public class TestResultDTO {

    private int answerCode;
    private int answerScore;

    private int totalScore;

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    private String testCategory;
    private String USER_ID;

    public TestResultDTO() {
    }

    public TestResultDTO(int answerScore, String testCategory) {
        this.answerScore = answerScore;
        this.testCategory = testCategory;
    }

    public TestResultDTO(int answerCode, int answerScore, String testCategory, String USER_ID) {
        this.answerCode = answerCode;
        this.answerScore = answerScore;
        this.testCategory = testCategory;
        this.USER_ID = USER_ID;
    }

    public int getAnswerCode() {
        return answerCode;
    }

    public void setAnswerCode(int answerCode) {
        this.answerCode = answerCode;
    }

    public int getAnswerScore() {
        return answerScore;
    }

    public void setAnswerScore(int answerScore) {
        this.answerScore = answerScore;
    }

    public String getTestCategory() {
        return testCategory;
    }

    public void setTestCategory(String testCategory) {
        this.testCategory = testCategory;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    @Override
    public String toString() {
        return "TestResultDTO{" +
                "answerCode=" + answerCode +
                ", answerScore=" + answerScore +
                ", testCategory='" + testCategory + '\'' +
                ", USER_ID='" + USER_ID + '\'' +
                '}';
    }
}
