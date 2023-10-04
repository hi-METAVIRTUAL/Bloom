package com.metavirtual.bloom.myPage.adminPage.model.dto;

public class TherapistComment {
    private String title;
    private String name;
    private String postedDate;
    private int boardCode;

    public TherapistComment() {
    }

    public TherapistComment(String title, String name, String postedDate, int boardCode) {
        this.title = title;
        this.name = name;
        this.postedDate = postedDate;
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

    public int getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(int boardCode) {
        this.boardCode = boardCode;
    }

    @Override
    public String toString() {
        return "TherapistComment{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", boardCode=" + boardCode +
                '}';
    }
}
