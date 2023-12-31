package com.metavirtual.bloom.user.model.dto;

import java.util.List;

public class MemberDTO {
    private String userId;
    private String etcContent;
    private char testStatus;
    private char therapistGenderCK;
    private String nickname;
    private int reportCount;
    private char relationCK;

    public MemberDTO() {
    }

    public MemberDTO(String userId, String etcContent, char testStatus, char therapistGenderCK, String nickname, int reportCount, char relationCK) {
        this.userId = userId;
        this.etcContent = etcContent;
        this.testStatus = testStatus;
        this.therapistGenderCK = therapistGenderCK;
        this.nickname = nickname;
        this.reportCount = reportCount;
        this.relationCK = relationCK;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEtcContent() {
        return etcContent;
    }

    public void setEtcContent(String etcContent) {
        this.etcContent = etcContent;
    }

    public char getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(char testStatus) {
        this.testStatus = testStatus;
    }

    public char getTherapistGenderCK() {
        return therapistGenderCK;
    }

    public void setTherapistGenderCK(char therapistGenderCK) {
        this.therapistGenderCK = therapistGenderCK;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getReportCount() {
        return reportCount;
    }

    public void setReportCount(int reportCount) {
        this.reportCount = reportCount;
    }

    public char getRelationCK() {
        return relationCK;
    }

    public void setRelationCK(char relationCK) {
        this.relationCK = relationCK;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "userId='" + userId + '\'' +
                ", etcContent='" + etcContent + '\'' +
                ", testStatus=" + testStatus +
                ", therapistGenderCK=" + therapistGenderCK +
                ", nickname='" + nickname + '\'' +
                ", reportCount=" + reportCount +
                ", relationCK=" + relationCK +
                '}';
    }
}
