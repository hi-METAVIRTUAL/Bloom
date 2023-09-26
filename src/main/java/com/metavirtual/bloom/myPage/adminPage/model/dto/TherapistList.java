package com.metavirtual.bloom.myPage.adminPage.model.dto;

import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

public class TherapistList {

    private String userId;
    private String name;
    private String registDate;
    private char confirmedStatus;

    public TherapistList() {
    }

    public TherapistList(String userId, String name, String registDate, char confirmedStatus) {
        this.userId = userId;
        this.name = name;
        this.registDate = registDate;
        this.confirmedStatus = confirmedStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    public char getConfirmedStatus() {
        return confirmedStatus;
    }

    public void setConfirmedStatus(char confirmedStatus) {
        this.confirmedStatus = confirmedStatus;
    }

    @Override
    public String toString() {
        return "TherapistList{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", registDate='" + registDate + '\'' +
                ", confirmedStatus=" + confirmedStatus +
                '}';
    }
}
