package com.metavirtual.bloom.myPage.memberPage.model.dto;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;

public class CommentListDTO {
    private MemberCommentDTO commentDTO;
    private BoardDTO boardDTO;

    public CommentListDTO() {
    }

    public CommentListDTO(MemberCommentDTO commentDTO, BoardDTO boardDTO) {
        this.commentDTO = commentDTO;
        this.boardDTO = boardDTO;
    }

    public MemberCommentDTO getCommentDTO() {
        return commentDTO;
    }

    public void setCommentDTO(MemberCommentDTO commentDTO) {
        this.commentDTO = commentDTO;
    }

    public BoardDTO getBoardDTO() {
        return boardDTO;
    }

    public void setBoardDTO(BoardDTO boardDTO) {
        this.boardDTO = boardDTO;
    }

    @Override
    public String toString() {
        return "CommentListDTO{" +
                "commentDTO=" + commentDTO +
                ", boardDTO=" + boardDTO +
                '}';
    }
}
