package com.metavirtual.bloom.user.model.dto;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

public class UserImpl /*extends User*/ {

    private String userId;
    private String pwd;
    private String name;
    private char gender;
    private String email;
    private String phone;
    private String registDate;
    private String unregistDate;


/*    public UserImpl(String userId, String pwd, Collection<? extends GrantedAuthority> authorities) {
        super(userId, pwd, authorities);
    }*/

    public void setDetails(UserDTO user){
        this.userId = user.getUserId();
        this.pwd = user.getPwd();
        this.name = user.getName();
        this.gender = user.getGender();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.registDate = user.getRegistDate();
        this.unregistDate = user.getUnregistDate();
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


    @Override
    public String toString() {
        return "UserImpl{" +
                "userId='" + userId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registDate='" + registDate + '\'' +
                ", unregistDate='" + unregistDate +
                '}';
    }
}
