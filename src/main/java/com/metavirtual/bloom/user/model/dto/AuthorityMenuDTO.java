package com.metavirtual.bloom.user.model.dto;

import lombok.Getter;

public class AuthorityMenuDTO {


    private int authorityCode;  //권한코드
    private int menuCode;       //메뉴코드
    private MenuDTO menu;       //메뉴상세정보

    public AuthorityMenuDTO() {
    }

    public AuthorityMenuDTO(int authorityCode, int menuCode, MenuDTO menu) {
        this.authorityCode = authorityCode;
        this.menuCode = menuCode;
        this.menu = menu;
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

    public MenuDTO getMenu() {
        return menu;
    }

    public void setMenu(MenuDTO menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "AuthorityMenuDTO{" +
                "authorityCode=" + authorityCode +
                ", menuCode=" + menuCode +
                ", menu=" + menu +
                '}';
    }
}
