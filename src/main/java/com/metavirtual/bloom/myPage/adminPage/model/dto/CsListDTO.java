package com.metavirtual.bloom.myPage.adminPage.model.dto;

public class CsListDTO {
    private int boardCode;
    private String title;
    private String postedDate;
    private String userId;
    private int commentNumber;

    public CsListDTO() {
    }

    public CsListDTO(int boardCode, String title, String postedDate, String userId, int commentNumber) {
        this.boardCode = boardCode;
        this.title = title;
        this.postedDate = postedDate;
        this.userId = userId;
        this.commentNumber = commentNumber;
    }

    public int getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(int boardCode) {
        this.boardCode = boardCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    @Override
    public String toString() {
        return "CsListDTO{" +
                "boardCode=" + boardCode +
                ", title='" + title + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", userId='" + userId + '\'' +
                ", commentNumber=" + commentNumber +
                '}';
    }
}
