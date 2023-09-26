package com.metavirtual.bloom.board.model.dto;

import com.metavirtual.bloom.user.model.dto.MemberDTO;

public class BoardDTO {
    private int boardCode; //게시글코드
    private String title; // 제목
    private String postedDate; // 게시물 작성일시
    private String deleteDate; // 게시물 삭제일시
    private int viewCount; // 게시물 조회 수
    private String boardCategory; // 게시글 분류
    private String boardContent; // 게시글 내용
    private MemberDTO userId;
    private String refUserId; // MemberDTO userId 불러와야함
    private String refNickname; // MemberDTO nickname 불러와야함

    public BoardDTO() {
    }

    public BoardDTO(int boardCode, String title, String postedDate, String deleteDate, int viewCount, String boardCategory, String boardContent, MemberDTO userId, String refUserId, String refNickname) {
        this.boardCode = boardCode;
        this.title = title;
        this.postedDate = postedDate;
        this.deleteDate = deleteDate;
        this.viewCount = viewCount;
        this.boardCategory = boardCategory;
        this.boardContent = boardContent;
        this.userId = userId;
        this.refUserId = refUserId;
        this.refNickname = refNickname;
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

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getBoardCategory() {
        return boardCategory;
    }

    public void setBoardCategory(String boardCategory) {
        this.boardCategory = boardCategory;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public MemberDTO getUserId() {
        return userId;
    }

    public void setUserId(MemberDTO userId) {
        this.userId = userId;
    }

    public String getRefUserId() {
        refUserId = userId.getUserId();
        return refUserId;
    }

    public void setRefUserId(String refUserId) {
        this.refUserId = refUserId;
    }

    public String getRefNickname() {
        refNickname = userId.getNickname();
        return refNickname;
    }

    public void setRefNickname(String refNickname) {
        this.refNickname = refNickname;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "boardCode=" + boardCode +
                ", title='" + title + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", viewCount=" + viewCount +
                ", boardCategory='" + boardCategory + '\'' +
                ", boardContent='" + boardContent + '\'' +
                ", userId=" + userId +
                ", refUserId='" + refUserId + '\'' +
                ", refNickname='" + refNickname + '\'' +
                '}';
    }
}
