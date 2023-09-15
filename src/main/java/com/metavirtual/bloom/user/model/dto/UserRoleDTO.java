package com.metavirtual.bloom.user.model.dto;

public class UserRoleDTO {

    private String userId;                //회원아이디
    private int authorityCode;            //권한코드
    private AuthorityDTO authority;       //회원보유권한

    public UserRoleDTO() {
    }

    public UserRoleDTO(String userId, int authorityCode, AuthorityDTO authority) {
        this.userId = userId;
        this.authorityCode = authorityCode;
        this.authority = authority;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(int authorityCode) {
        this.authorityCode = authorityCode;
    }

    public AuthorityDTO getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityDTO authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "UserRoleDTO{" +
                "userId='" + userId + '\'' +
                ", authorityCode=" + authorityCode +
                ", authority=" + authority +
                '}';
    }
}
