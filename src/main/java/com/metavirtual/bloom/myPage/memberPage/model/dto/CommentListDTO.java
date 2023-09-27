package com.metavirtual.bloom.myPage.memberPage.model.dto;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;

public class CommentListDTO {
    private int commentCode;
    private String title;
    private String commentContent;
    private String postedDate;

    public CommentListDTO() {
    }

    public CommentListDTO(int commentCode, String title, String commentContent, String postedDate) {
        this.commentCode = commentCode;
        this.title = title;
        this.commentContent = commentContent;
        this.postedDate = postedDate;
    }

    public int getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(int commentCode) {
        this.commentCode = commentCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "CommentListDTO{" +
                "commentCode=" + commentCode +
                ", title='" + title + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", postedDate='" + postedDate + '\'' +
                '}';
    }
}
