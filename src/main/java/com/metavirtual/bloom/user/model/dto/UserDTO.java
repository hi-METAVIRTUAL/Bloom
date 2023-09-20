package com.metavirtual.bloom.user.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDTO implements UserDetails {

    private String userId;
    private String pwd;
    private String name;
    private char gender;
    private String email;
    private String phone;
    private String registDate;
    private String unregistDate;
    private int authority_code;

    public UserDTO() {
    }

    public UserDTO(String userId, String pwd, String name, char gender, String email, String phone, String registDate, String unregistDate, int authority_code) {
        this.userId = userId;
        this.pwd = pwd;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.registDate = registDate;
        this.authority_code = authority_code;
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

    public int getAuthority_code() {
        return authority_code;
    }

    public void setAuthority_code(int authority_code) {
        this.authority_code = authority_code;
    }

    @Override
    public String toString() {
        return "UserInfo_DTO{" +
                "userId='" + userId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registDate='" + registDate + '\'' +
                ", authority_code='" + authority_code +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
