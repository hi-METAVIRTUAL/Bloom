package com.metavirtual.bloom.myPage.adminPage.model.dto;

public class PostResult {

    private int boardCode;
    private String title;
    private String boardCategory;
    private String postedDate;
    private String nickname;

    public PostResult() {
    }

    public PostResult(int boardCode, String title, String boardCategory, String postedDate, String nickname) {
        this.boardCode = boardCode;
        this.title = title;
        this.boardCategory = boardCategory;
        this.postedDate = postedDate;
        this.nickname = nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "PostResult{" +
                "boardCode=" + boardCode +
                ", title='" + title + '\'' +
                ", boardCategory='" + boardCategory + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
