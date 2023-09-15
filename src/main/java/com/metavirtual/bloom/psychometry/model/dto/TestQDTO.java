package com.metavirtual.bloom.psychometry.model.dto;

import org.springframework.beans.factory.annotation.Value;

public class TestQDTO {

    private int testCode;
    private String testContent;
    private String testCategory;

    public TestQDTO() {
    }

    public TestQDTO(int testCode, String testContent, String testCategory) {
        this.testCode = testCode;
        this.testContent = testContent;
        this.testCategory = testCategory;
    }

    public int getTestCode() {
        return testCode;
    }

    public void setTestCode(int testCode) {
        this.testCode = testCode;
    }

    public String getTestContent() {
        return testContent;
    }

    public void setTestContent(String testContent) {
        this.testContent = testContent;
    }

    public String getTestCategory() {
        return testCategory;
    }

    public void setTestCategory(String testCategory) {
        this.testCategory = testCategory;
    }

    @Override
    public String toString() {
        return "TestQDTO{" +
                "testCode=" + testCode +
                ", testContent='" + testContent + '\'' +
                ", testCategory='" + testCategory + '\'' +
                '}';
    }
}
