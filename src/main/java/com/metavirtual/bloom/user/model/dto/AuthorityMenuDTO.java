package com.metavirtual.bloom.user.model.dto;

import lombok.Getter;

public class AuthorityMenuDTO {


    private int authorityCode;  //권한코드
    private int menuCode;       //메뉴코드

    public AuthorityMenuDTO() {
    }

    public AuthorityMenuDTO(int authorityCode, int menuCode) {
        this.authorityCode = authorityCode;
        this.menuCode = menuCode;
    }

    public int getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(int authorityCode) {
        this.authorityCode = authorityCode;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    @Override
    public String toString() {
        return "AuthorityMenuDTO{" +
                "authorityCode=" + authorityCode +
                ", menuCode=" + menuCode +
                '}';
    }
}
