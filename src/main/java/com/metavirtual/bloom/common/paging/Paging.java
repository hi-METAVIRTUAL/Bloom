package com.metavirtual.bloom.common.paging;


import com.metavirtual.bloom.model.dto.community.SelectCriteria;

public class Paging {
/*
    public static SelectCriteria getSelectCriteria (int pageNo, int totalBoardCount, int limitPerPage, int buttonAmount) {
        return getSelectCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount*//*, null, null*//*);
    }

    public static SelectCriteria getSelectCriteria (int pageNo, int totalBoardCount, int limitPerPage, int buttonAmount, String searchCondition, String searchValue) {

        int lastPage;
        int startPage;
        int endPage;
        int startRow;
        int endRow;

        *//* 총 페이지 숫자 산정 *//*

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

        SelectCriteria selectCriteria = new SelectCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount, lastPage, startPage, endPage, startRow, endRow, searchCondition, searchValue);

        return  selectCriteria;
    }
    */
}

