package com.metavirtual.bloom.user.model.dto;

import java.util.List;

public class UserDTO {

    private String userId;
    private String name;
    private char gender;
    private String email;
    private String phone;
    private String registDate;
    private String unregistDate;
    private List<UserRoleDTO> userInfoRoleList;		// 회원별권한리스트

    public UserDTO() {
    }

    public UserDTO(String userId, String name, char gender, String email, String phone, String registDate, String unregistDate, List<UserRoleDTO> userInfoRoleList) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.registDate = registDate;
        this.unregistDate = unregistDate;
        this.userInfoRoleList = userInfoRoleList;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    public String getUnregistDate() {
        return unregistDate;
    }

    public void setUnregistDate(String unregistDate) {
        this.unregistDate = unregistDate;
    }

    public List<UserRoleDTO> getUserInfoRoleList() {
        return userInfoRoleList;
    }
    public List<UserRoleDTO> setUserInfoRoleList() {
        return userInfoRoleList;
    }
    @Override
    public String toString() {
        return "UserInfo_DTO{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registDate='" + registDate + '\'' +
                ", unregistDate='" + unregistDate + '\'' +
                ", userInfoRoleList=" + userInfoRoleList +
                '}';
    }

}
