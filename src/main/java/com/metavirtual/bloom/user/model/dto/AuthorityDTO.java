package com.metavirtual.bloom.user.model.dto;

import java.util.List;

public class AuthorityDTO {
    private int authorityCode;                              // 권한코드
    private String authorityName;                           // 권한명
    private List<AuthorityMenuDTO> authorityMenuList;    // 권한별 인가된 메뉴 목록

    public AuthorityDTO() {
    }

    public AuthorityDTO(int authorityCode, String authorityName, List<AuthorityMenuDTO> authorityMenuList) {
        this.authorityCode = authorityCode;
        this.authorityName = authorityName;
        this.authorityMenuList = authorityMenuList;
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

    public List<AuthorityMenuDTO> getAuthorityMenuList() {
        return authorityMenuList;
    }

    public void setAuthorityMenuList(List<AuthorityMenuDTO> authorityMenuList) {
        this.authorityMenuList = authorityMenuList;
    }

    @Override
    public String toString() {
        return "AuthorityDTO{" +
                "authorityCode=" + authorityCode +
                ", authorityName='" + authorityName + '\'' +
                ", authorityMenuList=" + authorityMenuList +
                '}';
    }
}
