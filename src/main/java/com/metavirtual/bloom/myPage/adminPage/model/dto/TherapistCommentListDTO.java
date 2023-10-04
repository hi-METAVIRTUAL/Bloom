package com.metavirtual.bloom.myPage.adminPage.model.dto;

public class TherapistCommentListDTO {
    private int commentNumber;
    private String postedDate;
    private String deleteDate;
    private String commentContent;
    private int boardCode;
    private String userId;

    public TherapistCommentListDTO() {
    }

    public TherapistCommentListDTO(int commentNumber, String postedDate, String deleteDate, String commentContent, int boardCode, String userId) {
        this.commentNumber = commentNumber;
        this.postedDate = postedDate;
        this.deleteDate = deleteDate;
        this.commentContent = commentContent;
        this.boardCode = boardCode;
        this.userId = userId;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(int boardCode) {
        this.boardCode = boardCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TherapistCommentListDTO{" +
                "commentNumber=" + commentNumber +
                ", postedDate='" + postedDate + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", boardCode=" + boardCode +
                ", userId='" + userId + '\'' +
                '}';
    }
}
