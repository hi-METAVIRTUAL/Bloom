package com.metavirtual.bloom.model.dto.community;

public class BoardDTO {
    private int boardCode; //게시글코드
    private String title; // 제목
    private String postedDate; // 게시물 작성일시
    private String deleteDate; // 게시물 삭제일시
    private int viewCount; // 게시물 조회 수
    private String boardCategory; // 게시글 분류
    private String boardContent; // 게시글 내용
    private String userId; // UserInfoDTO의 userId 불러와야함
}
