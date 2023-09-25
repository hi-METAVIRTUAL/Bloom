package com.metavirtual.bloom.user.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDTO{

    private String userId;
    private String pwd;
    private String name;
    private char gender;
    private String email;
    private String phone;
    private String registDate;
    private String unregistDate;
    private int authorityCode;

    public UserDTO() {
    }

    public UserDTO(String userId, String pwd, String name, char gender, String email, String phone, String registDate, String unregistDate, int authorityCode) {
        this.userId = userId;
        this.pwd = pwd;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.registDate = registDate;
        this.unregistDate = unregistDate;
        this.authorityCode = authorityCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public int getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(int authorityCode) {
        this.authorityCode = authorityCode;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registDate='" + registDate + '\'' +
                ", unregistDate='" + unregistDate + '\'' +
                ", authorityCode='" + authorityCode +
                '}';
    }

}
