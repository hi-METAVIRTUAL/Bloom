package com.metavirtual.bloom.board.model.dto;

public class BoardReportDTO {
    private int reportCode;  // 게시글 신고코드
    private String reportedDate; // 게시글 신고일시
    private String reportCategory; //  신고분류
    private String reportContent; // 신고내용
    private String userId; // 신고한 회원 id
    private int boardCode; // 게시글코드

    public BoardReportDTO() {
    }

    public BoardReportDTO(int reportCode, String reportedDate, String reportCategory, String reportContent, String userId, int boardCode) {
        this.reportCode = reportCode;
        this.reportedDate = reportedDate;
        this.reportCategory = reportCategory;
        this.reportContent = reportContent;
        this.userId = userId;
        this.boardCode = boardCode;
    }

    public int getReportCode() {
        return reportCode;
    }

    public void setReportCode(int reportCode) {
        this.reportCode = reportCode;
    }

    public String getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(String reportedDate) {
        this.reportedDate = reportedDate;
    }

    public String getReportCategory() {
        return reportCategory;
    }

    public void setReportCategory(String reportCategory) {
        this.reportCategory = reportCategory;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(int boardCode) {
        this.boardCode = boardCode;
    }

    @Override
    public String toString() {
        return "BoardReportDTO{" +
                "reportCode=" + reportCode +
                ", reportedDate='" + reportedDate + '\'' +
                ", reportCategory='" + reportCategory + '\'' +
                ", reportContent='" + reportContent + '\'' +
                ", userId='" + userId + '\'' +
                ", boardCode=" + boardCode +
                '}';
    }
}
