package com.metavirtual.bloom.myPage.adminPage.model.dto;

public class CsDetailDTO {
    private int boardCode;
    private String title;
    private String name;
    private String postedDate;
    private String boardContent;
    private String commentContent;

    public CsDetailDTO() {
    }

    public CsDetailDTO(int boardCode, String title, String name, String postedDate, String boardContent, String commentContent) {
        this.boardCode = boardCode;
        this.title = title;
        this.name = name;
        this.postedDate = postedDate;
        this.boardContent = boardContent;
        this.commentContent = commentContent;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public String toString() {
        return "CsDetailDTO{" +
                "boardCode=" + boardCode +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", boardContent='" + boardContent + '\'' +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
