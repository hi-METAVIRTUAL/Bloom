package com.metavirtual.bloom.common.paging;

public class SelectCriteria {

    private int pageNo; // 선택한 페이지 번호
    private int totalBoardCount; // 전체 게시물 갯수
    private int limitPerPage; // 페이지 내 보여지는 게시물 갯수
    private int buttonAmount; // 한번에 보여줄 페이징 버튼 갯수
    private int lastPage; // 마지막 페이지 숫자
    private int startPage; // 버튼 어마운트 시작 페이지
    private int endPage; // 버튼 어마운트 끝 페이지
    private int startRow; // 조회 해야하는 시작 행의 숫자
    private int endRow; // 조회 해야하는 마지막 행의 숫자
    /* 검색 창 */
    private String searchInput; // 검색조건
    private String searchContent; // 검색 텍스트
}
