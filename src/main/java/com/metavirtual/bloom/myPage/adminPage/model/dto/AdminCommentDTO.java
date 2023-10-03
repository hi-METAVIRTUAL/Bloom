package com.metavirtual.bloom.myPage.adminPage.model.dto;

public class AdminCommentDTO {
    private int commentNumber;
    private int boardCode;
    private String postedDate;
    private String commentContent;
    private String deleteDate;
    private String userId;

    public AdminCommentDTO() {
    }

    public AdminCommentDTO(int commentNumber, int boardCode, String postedDate, String commentContent, String deleteDate, String userId) {
        this.commentNumber = commentNumber;
        this.boardCode = boardCode;
        this.postedDate = postedDate;
        this.commentContent = commentContent;
        this.deleteDate = deleteDate;
        this.userId = userId;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public int getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(int boardCode) {
        this.boardCode = boardCode;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AdminCommentDTO{" +
                "commentNumber=" + commentNumber +
                ", boardCode=" + boardCode +
                ", postedDate='" + postedDate + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
