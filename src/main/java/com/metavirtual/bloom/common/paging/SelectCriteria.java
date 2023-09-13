package com.metavirtual.bloom.common.paging;

public class SelectCriteria {

    private int pageNo; // 선택한 페이지 번호
    private int totalBoardCount; // 전체 게시물 갯수
    private int limitPerPage; // 페이지 내 보여지는 게시물 갯수
    private int buttonAmount; // 한번에 보여줄 페이징 버튼 갯수
    private int lastPage; // 마지막 페이지
    private int startPage; // 버튼 어마운트 시작 페이지
    private int endPage; // 버튼 어마운트 끝 페이지
    private int startRow; // 조회 해야하는 시작 행의 숫자
    private int endRow; // 조회 해야하는 마지막 행의 숫자
    /* 검색 창 */
    private String searchCondition; // 검색조건
    private String searchValue; // 검색 텍스트

    public SelectCriteria() {
    }

    public SelectCriteria(int pageNo, int totalBoardCount, int limitPerPage, int buttonAmount, int lastPage, int startPage, int endPage, int startRow, int endRow, String searchCondition, String searchValue) {
        this.pageNo = pageNo;
        this.totalBoardCount = totalBoardCount;
        this.limitPerPage = limitPerPage;
        this.buttonAmount = buttonAmount;
        this.lastPage = lastPage;
        this.startPage = startPage;
        this.endPage = endPage;
        this.startRow = startRow;
        this.endRow = endRow;
        this.searchCondition = searchCondition;
        this.searchValue = searchValue;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalBoardCount() {
        return totalBoardCount;
    }

    public void setTotalBoardCount(int totalBoardCount) {
        this.totalBoardCount = totalBoardCount;
    }

    public int getLimitPerPage() {
        return limitPerPage;
    }

    public void setLimitPerPage(int limitPerPage) {
        this.limitPerPage = limitPerPage;
    }

    public int getButtonAmount() {
        return buttonAmount;
    }

    public void setButtonAmount(int buttonAmount) {
        this.buttonAmount = buttonAmount;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public String getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    @Override
    public String toString() {
        return "SelectCriteria{" +
                "pageNo=" + pageNo +
                ", totalBoardCount=" + totalBoardCount +
                ", limitPerPage=" + limitPerPage +
                ", buttonAmount=" + buttonAmount +
                ", lastPage=" + lastPage +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                ", searchCondition='" + searchCondition + '\'' +
                ", searchValue='" + searchValue + '\'' +
                '}';
    }
}
