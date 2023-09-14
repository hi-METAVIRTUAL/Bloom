package com.metavirtual.bloom.board.model.dto;

public class BoardReportDTO {
    private int reportCode;  // 게시글 신고코드 - auto increment
    private String reportDate; // 게시글 신고일시
    private String reportContent; //  신고사유 - checkbox 를 통해 데이터 전송
    private String userId; // 신고한 회원 id - UserInfoDTO의 userId
    private int boardCode; // BoardDTO의 boardCode

}
