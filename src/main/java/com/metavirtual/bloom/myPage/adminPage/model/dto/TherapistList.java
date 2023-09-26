package com.metavirtual.bloom.myPage.adminPage.model.dto;

import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;

public class TherapistList {

    private UserDTO userId;
    private UserDTO name;
    private UserDTO registDate;
    private TherapistDTO confirmedStatus;

    public TherapistList() {
    }

    public TherapistList(UserDTO userId, UserDTO name, UserDTO registDate, TherapistDTO confirmedStatus) {
        this.userId = userId;
        this.name = name;
        this.registDate = registDate;
        this.confirmedStatus = confirmedStatus;
    }

    public UserDTO getUserId() {
        return userId;
    }

    public void setUserId(UserDTO userId) {
        this.userId = userId;
    }

    public UserDTO getName() {
        return name;
    }

    public void setName(UserDTO name) {
        this.name = name;
    }

    public UserDTO getRegistDate() {
        return registDate;
    }

    public void setRegistDate(UserDTO registDate) {
        this.registDate = registDate;
    }

    public TherapistDTO getConfirmedStatus() {
        return confirmedStatus;
    }

    public void setConfirmedStatus(TherapistDTO confirmedStatus) {
        this.confirmedStatus = confirmedStatus;
    }

    @Override
    public String toString() {
        return "TherapisList{" +
                "userId=" + userId +
                ", name=" + name +
                ", registDate=" + registDate +
                ", confirmedStatus=" + confirmedStatus +
                '}';
    }
}
