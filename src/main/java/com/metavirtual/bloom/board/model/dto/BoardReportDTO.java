package com.metavirtual.bloom.board.model.dto;

public class BoardReportDTO {
    private int reportCode;  // 게시글 신고코드 - auto increment
    private String reportDate; // 게시글 신고일시
    private String reportContent; //  신고사유 - checkbox 를 통해 데이터 전송
    private String userId; // 신고한 회원 id - UserInfoDTO의 userId
    private int boardCode; // BoardDTO의 boardCode

    public BoardReportDTO() {
    }

    public BoardReportDTO(int reportCode, String reportDate, String reportContent, String userId, int boardCode) {
        this.reportCode = reportCode;
        this.reportDate = reportDate;
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
                ", reportDate='" + reportDate + '\'' +
                ", reportContent='" + reportContent + '\'' +
                ", userId='" + userId + '\'' +
                ", boardCode=" + boardCode +
                '}';
    }
}
