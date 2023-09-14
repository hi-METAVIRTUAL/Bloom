package com.metavirtual.bloom.board.model.dto;

public class CommentReportDTO {
    private int reportCode;
    private String reportDate;
    private String reportContent;
    private String userId;
    private int commentCode;
    private int boardCode;

    public CommentReportDTO() {
    }

    public CommentReportDTO(int reportCode, String reportDate, String reportContent, String userId, int commentCode, int boardCode) {
        this.reportCode = reportCode;
        this.reportDate = reportDate;
        this.reportContent = reportContent;
        this.userId = userId;
        this.commentCode = commentCode;
        this.boardCode = boardCode;
    }

    public int getReportCode() {
        return reportCode;
    }

    public void setReportCode(int reportCode) {
        this.reportCode = reportCode;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
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

    public int getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(int commentCode) {
        this.commentCode = commentCode;
    }

    public int getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(int boardCode) {
        this.boardCode = boardCode;
    }

    @Override
    public String toString() {
        return "CommentReportDTO{" +
                "reportCode=" + reportCode +
                ", reportDate='" + reportDate + '\'' +
                ", reportContent='" + reportContent + '\'' +
                ", userId='" + userId + '\'' +
                ", commentCode=" + commentCode +
                ", boardCode=" + boardCode +
                '}';
    }
}