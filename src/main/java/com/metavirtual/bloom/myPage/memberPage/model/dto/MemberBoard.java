package com.metavirtual.bloom.myPage.memberPage.model.dto;

public class MemberBoard {
    private int boardCode;
    private String title;
    private String boardCategory;
    private String postedDate;

    public MemberBoard() {
    }

    public MemberBoard(int boardCode, String title, String boardCategory, String postedDate) {
        this.boardCode = boardCode;
        this.title = title;
        this.boardCategory = boardCategory;
        this.postedDate = postedDate;
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

    public String getBoardCategory() {
        return boardCategory;
    }

    public void setBoardCategory(String boardCategory) {
        this.boardCategory = boardCategory;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    @Override
    public String toString() {
        return "MemberBoard{" +
                "boardCode=" + boardCode +
                ", title='" + title + '\'' +
                ", boardCategory='" + boardCategory + '\'' +
                ", postedDate='" + postedDate + '\'' +
                '}';
    }
}
