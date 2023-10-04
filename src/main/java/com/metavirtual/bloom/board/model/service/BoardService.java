package com.metavirtual.bloom.board.model.service;

import com.metavirtual.bloom.board.model.dao.BoardMapper;
import com.metavirtual.bloom.board.model.dto.*;
import com.metavirtual.bloom.common.exception.board.*;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dto.TherapistCommentListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public int selectTotalCount(Map<String, String> searchMap) {


        int result = boardMapper.selectTotalCount(searchMap);
        return result;
    }


    /* 전체 게시글 조회 */
    public List<BoardDTO> findAllBoard(SelectCriteria selectCriteria) {
        List<BoardDTO> boardList = boardMapper.findAllBoard(selectCriteria);

        return boardList;
    }

    /* 게시글 상세 조회 */
    @Transactional
    public BoardDTO boardSelectOne(int boardCode) {
        BoardDTO selectOne = null;

        int result = boardMapper.viewCount(boardCode);
        System.out.println("서비스확인 : " + result);
        if(result > 0) {
            selectOne = boardMapper.boardSelectOne(boardCode);
            System.out.println("서비스확인2: " + selectOne);
        }

        return selectOne;
    }

    /* 게시글 등록 */
    @Transactional
    public void boardNewPosting(MemberBoardDTO newPosting) throws BoardPostingException {

        int result = boardMapper.boardNewPosting(newPosting);
        if(!(result > 0)) {
            throw new BoardPostingException("게시글 등록에 실패하였습니다.");
        }
    }

    /* 게시글 수정 */
    @Transactional
    public void boardModify(MemberBoardDTO modifyBoard) throws BoardModifyException {

        int result = boardMapper.boardModify(modifyBoard);

        if(!(result > 0)) {
            throw new BoardModifyException("게시글 수정에 실패하였습니다");
        }
    }
    /* 게시글 삭제 */
    @Transactional
    public void boardDelete(MemberBoardDTO deleteBoard) throws BoardDeleteException {
        int result = boardMapper.boardDelete(deleteBoard);

        if(!(result > 0)) {
            throw new BoardDeleteException("게시글 삭제에 실패하였습니다");
        }
    }

    /* 댓글 리스트 조회 */
    public List<MemberCommentDTO> searchAllComment(int boardCode) {
        List<MemberCommentDTO> commentList;
        commentList = boardMapper.searchCommentList(boardCode);

        return commentList;
    }

    /* 댓글 등록 */
    @Transactional
    public List<MemberCommentDTO> commentNewPosting(MemberCommentDTO newComment) throws CommentPostingException {

        List<MemberCommentDTO> commentList;

        int result = boardMapper.commentPosting(newComment);

        if(result > 0) {
            commentList = boardMapper.searchCommentList(newComment.getBoardCode());
        } else {
            throw new CommentPostingException("댓글 등록에 실패하였습니다.");
        }

        return commentList;
    }

    /* 댓글 삭제 */
    @Transactional
    public List<MemberCommentDTO> commentDelete(MemberCommentDTO commentDelete) throws CommentDeleteException {

        List<MemberCommentDTO> commentList;

        int result = boardMapper.commentDelete(commentDelete.getCommentCode());

        if(result > 0) {
            commentList = boardMapper.searchCommentList(commentDelete.getBoardCode());
        } else {
            throw new CommentDeleteException("댓글 삭제에 실패하셨습니다.");
        }

        return commentList;
    }

    /* 게시글 신고 */
    @Transactional
    public void reportInsert(BoardReportDTO newReport) throws ReportInsertException {


        int result = boardMapper.reportInsert(newReport);

        if (result > 0) {
            boardMapper.reportCount(newReport.getBoardCode());
        } else {
            throw new ReportInsertException("게시글 등록에 실패하였습니다");
        }

    }

    /*@Transactional
    public TherapistCommentListDTO searchTherapistList(int boardCode) {
        TherapistCommentListDTO selectOne = null;


            selectOne = boardMapper.counselSelectOne(boardCode);
            System.out.println("서비스확인2: " + selectOne);


        return selectOne;
    }*/
/*
    public List<TherapistCommentListDTO> searchTherapistComment(int boardCode) {
        List<TherapistCommentListDTO> therapistCommList;

        therapistCommList = boardMapper.searchTherapistComment(boardCode);


        return therapistCommList;
    }


    @Transactional
    public List<TherapistCommentListDTO> commentTherapist(TherapistCommentListDTO newTherapistComment) throws TherapistCommentException {
        List<TherapistCommentListDTO> therapistCommList;

        int result = boardMapper.therapistComment(newTherapistComment);

        if(result > 0) {
            therapistCommList = boardMapper.searchTherapistComment(newTherapistComment.getBoardCode());
        } else {
            throw new TherapistCommentException("답변 등록에 실패하였습니다.");
        }

        return therapistCommList;

    }*/
}


