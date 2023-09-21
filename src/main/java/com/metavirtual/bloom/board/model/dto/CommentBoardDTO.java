package com.metavirtual.bloom.board.model.dto;

/* 댓글 등록용 객체 */
public class CommentBoardDTO {
    private int commentCode;
    private String commentContent;
    private String postedDate;
    private String deleteDate;
    private int boardCode;
    private String userId;

    public CommentBoardDTO() {
    }

    public CommentBoardDTO(int commentCode, String commentContent, String postedDate, String deleteDate, int boardCode, String userId) {
        this.commentCode = commentCode;
        this.commentContent = commentContent;
        this.postedDate = postedDate;
        this.deleteDate = deleteDate;
        this.boardCode = boardCode;
        this.userId = userId;
    }

    public int getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(int commentCode) {
        this.commentCode = commentCode;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public int getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(int boardCode) {
        this.boardCode = boardCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CommentBoardDTO{" +
                "commentCode=" + commentCode +
                ", commentContent='" + commentContent + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", boardCode=" + boardCode +
                ", userId='" + userId + '\'' +
                '}';
    }
}
