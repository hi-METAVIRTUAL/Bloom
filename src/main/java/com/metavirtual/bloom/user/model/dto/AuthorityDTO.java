package com.metavirtual.bloom.user.model.dto;

import java.util.List;

public class AuthorityDTO {
    private int authorityCode;                              // 권한코드
    private String authorityName;                           // 권한명
    private List<AuthorityMenuDTO> authenicatedMenuList;    // 권한별 인가된 메뉴 목록

    public AuthorityDTO() {
    }

    public AuthorityDTO(int authorityCode, String authorityName, List<AuthorityMenuDTO> authenicatedMenuList) {
        this.authorityCode = authorityCode;
        this.authorityName = authorityName;
        this.authenicatedMenuList = authenicatedMenuList;
    }

    public int getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(int authorityCode) {
        this.authorityCode = authorityCode;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public List<AuthorityMenuDTO> getAuthenicatedMenuList() {
        return authenicatedMenuList;
    }

    public void setAuthenicatedMenuList(List<AuthorityMenuDTO> authenicatedMenuList) {
        this.authenicatedMenuList = authenicatedMenuList;
    }

    @Override
    public String toString() {
        return "AuthorityDTO{" +
                "authorityCode=" + authorityCode +
                ", authorityName='" + authorityName + '\'' +
                ", authenicatedMenuList=" + authenicatedMenuList +
                '}';
    }
}
