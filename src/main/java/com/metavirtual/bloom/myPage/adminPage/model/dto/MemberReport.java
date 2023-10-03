package com.metavirtual.bloom.myPage.adminPage.model.dto;

public class MemberReport {
    /*R.REPORT_CODE
            , B.TITLE
            , R.USER_ID
            , R.REPORTED_DATE
            , R.BOARD_CODE*/
    private int reportCode;
    private String title;
    private String userId;
    private String reportedDate;
    private int boardCode;

    public MemberReport() {
    }

    public MemberReport(int reportCode, String title, String userId, String reportedDate, int boardCode) {
        this.reportCode = reportCode;
        this.title = title;
        this.userId = userId;
        this.reportedDate = reportedDate;
        this.boardCode = boardCode;
    }

    public int getReportCode() {
        return reportCode;
    }

    public void setReportCode(int reportCode) {
        this.reportCode = reportCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(String reportedDate) {
        this.reportedDate = reportedDate;
    }

    public int getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(int boardCode) {
        this.boardCode = boardCode;
    }

    @Override
    public String toString() {
        return "MemberReport{" +
                "reportCode=" + reportCode +
                ", title='" + title + '\'' +
                ", userId='" + userId + '\'' +
                ", reportedDate='" + reportedDate + '\'' +
                ", boardCode=" + boardCode +
                '}';
    }
}
