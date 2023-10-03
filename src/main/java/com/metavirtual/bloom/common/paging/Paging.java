package com.metavirtual.bloom.common.paging;


public class Paging {
    public static SelectCriteria getSelectCriteria (int pageNo, int totalBoardCount, int limitPerPage, int buttonAmount) {
        return getSelectCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount, null, null, null);
    }

    public static SelectCriteria getSelectCriteria (int pageNo, int totalBoardCount, int limitPerPage, int buttonAmount, String searchCategory, String searchSelect, String searchValue) {

        int lastPage;
        int startPage;
        int endPage;
        int startRow;
        int endRow;

         /* 총 페이지 숫자 산정 */

        lastPage = (int) Math.ceil((double) totalBoardCount / limitPerPage);

        startPage = (int) (Math.ceil((double) pageNo / buttonAmount) - 1) * buttonAmount + 1;

        endPage = startPage + buttonAmount - 1;

        if(lastPage < endPage) {
            endPage = lastPage;
        }

        if(lastPage == 0 && endPage == 0) {
            endPage = startPage;
            lastPage = startPage;
        }

        startRow = (pageNo - 1) * limitPerPage;
        endRow = startRow + limitPerPage - 1;

        SelectCriteria selectCriteria = new SelectCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount, lastPage, startPage, endPage, startRow, endRow, searchCategory, searchSelect, searchValue);

        return  selectCriteria;
    }

    public static MatchCriteria getMatchCriteria (int pageNo, int totalBoardCount, int limitPerPage, int buttonAmount) {
        return getMatchCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount, ' ', ' ', ' ', ' ', ' ', null);
    }

    public static MatchCriteria getMatchCriteria (int pageNo, int totalBoardCount, int limitPerPage, int buttonAmount, char d, char a, char b, char o, char r, String searchValue) {

        int lastPage;
        int startPage;
        int endPage;
        int startRow;
        int endRow;

        /* 총 페이지 숫자 산정 */

        lastPage = (int) Math.ceil((double) totalBoardCount / limitPerPage);

        startPage = (int) (Math.ceil((double) pageNo / buttonAmount) - 1) * buttonAmount + 1;

        endPage = startPage + buttonAmount - 1;

        if(lastPage < endPage) {
            endPage = lastPage;
        }

        if(lastPage == 0 && endPage == 0) {
            endPage = startPage;
            lastPage = startPage;
        }

        startRow = (pageNo - 1) * limitPerPage;
        endRow = startRow + limitPerPage - 1;

        MatchCriteria matchCriteria = new MatchCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount, lastPage, startPage, endPage, startRow, endRow, d, a, b, o, r, searchValue);

        return matchCriteria;
    }

    public static AdminCriteria getAdminCriteria (int pageNo, int totalBoardCount, int limitPerPage, int buttonAmount) {
        return getAdminCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount, null, null);
    }

    public static AdminCriteria getAdminCriteria (int pageNo, int totalBoardCount, int limitPerPage, int buttonAmount, String searchSelect, String searchValue) {

        int lastPage;
        int startPage;
        int endPage;
        int startRow;
        int endRow;

        /* 총 페이지 숫자 산정 */

        lastPage = (int) Math.ceil((double) totalBoardCount / limitPerPage);

        startPage = (int) (Math.ceil((double) pageNo / buttonAmount) - 1) * buttonAmount + 1;

        endPage = startPage + buttonAmount - 1;

        if(lastPage < endPage) {
            endPage = lastPage;
        }

        if(lastPage == 0 && endPage == 0) {
            endPage = startPage;
            lastPage = startPage;
        }

        startRow = (pageNo - 1) * limitPerPage;
        endRow = startRow + limitPerPage - 1;

        AdminCriteria adminCriteria = new AdminCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount, lastPage, startPage, endPage, startRow, endRow, searchSelect, searchValue);

        return  adminCriteria;
    }

}

