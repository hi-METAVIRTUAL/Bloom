package com.metavirtual.bloom.psychometry.model.dto;

public class TestResultDTO {

    private int answerCode;
    private int answerScore;

    private int totalScore;

    private String testCategory;
    private String userId;

    public TestResultDTO() {
    }

    public TestResultDTO(int answerCode, int answerScore, int totalScore, String testCategory, String userId) {
        this.answerCode = answerCode;
        this.answerScore = answerScore;
        this.totalScore = totalScore;
        this.testCategory = testCategory;
        this.userId = userId;
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

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getTestCategory() {
        return testCategory;
    }

    public void setTestCategory(String testCategory) {
        this.testCategory = testCategory;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TestResultDTO{" +
                "answerCode=" + answerCode +
                ", answerScore=" + answerScore +
                ", totalScore=" + totalScore +
                ", testCategory='" + testCategory + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
