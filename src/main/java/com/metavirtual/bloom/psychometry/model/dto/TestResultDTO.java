package com.metavirtual.bloom.psychometry.model.dto;

public class TestResultDTO {

    private int answerCode;
    private TestQDTO testCode;
    private int answerScore;

    public TestResultDTO() {
    }


    public TestResultDTO(int answerCode, TestQDTO testCode, int answerScore) {
        this.answerCode = answerCode;
        this.testCode = testCode;
        this.answerScore = answerScore;
    }

    public int getAnswerCode() {
        return answerCode;
    }

    public void setAnswerCode(int answerCode) {
        this.answerCode = answerCode;
    }

    public TestQDTO getTestCode() {
        return testCode;
    }

    public void setTestCode(TestQDTO testCode) {
        this.testCode = testCode;
    }

    public int getAnswerScore() {
        return answerScore;
    }

    public void setAnswerScore(int answerScore) {
        this.answerScore = answerScore;
    }

    @Override
    public String toString() {
        return "TestResultDTO{" +
                "answerCode=" + answerCode +
                ", testCode=" + testCode +
                ", answerScore=" + answerScore +
                '}';
    }
}
