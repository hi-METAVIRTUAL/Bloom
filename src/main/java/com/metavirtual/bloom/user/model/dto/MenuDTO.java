package com.metavirtual.bloom.user.model.dto;

public class MenuDTO {
    private int menuCode;
    private String menuName;
    private String menuUrl;
    private String menuContent;
    private String menuCategory;
    private Integer superMenuCode;

    public MenuDTO() {
    }

    public MenuDTO(int menuCode, String menuName, String menuUrl, String menuContent, String menuCategory, Integer superMenuCode) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.menuContent = menuContent;
        this.menuCategory = menuCategory;
        this.superMenuCode = superMenuCode;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuContent() {
        return menuContent;
    }

    public void setMenuContent(String menuContent) {
        this.menuContent = menuContent;
    }

    public String getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    public Integer getSuperMenuCode() {
        return superMenuCode;
    }

    public void setSuperMenuCode(Integer superMenuCode) {
        this.superMenuCode = superMenuCode;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuContent='" + menuContent + '\'' +
                ", menuCategory='" + menuCategory + '\'' +
                ", superMenuCode=" + superMenuCode +
                '}';
    }
}
