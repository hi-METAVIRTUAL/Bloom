
package com.metavirtual.bloom.board.model.service;

import com.metavirtual.bloom.board.model.dao.BoardMapper;
import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;
import com.metavirtual.bloom.common.exception.board.BoardPostingException;
import com.metavirtual.bloom.common.exception.board.CommentPostingException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
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

    /* 전체 게시글 조회 메서드 */
    public List<BoardDTO> findAllBoard(SelectCriteria selectCriteria) {
        List<BoardDTO> boardList = boardMapper.findAllBoard(selectCriteria);

        return boardList;
    }

    /**/
    @Transactional
    public BoardDTO boardSelectOne(int boardCode) {
        BoardDTO boardSelect = null;

        int result = boardMapper.viewCount(boardCode);

        if(result > 0) {
            boardSelect = boardMapper.boardSelectOne(boardCode);
        }

        return boardSelect;
    }



    /* boardInsert.html 게시글 등록 메서드 */
    @Transactional
    public void boardNewPosting(BoardDTO newPosting) throws BoardPostingException {
        int result = boardMapper.boardNewPosting(newPosting);

        if(!(result > 0)) {
            throw new BoardPostingException("게시글 등록에 실패하였습니다");
        }
    }

    public List<MemberCommentDTO> searchAllComment(int boardCode) {
        List<MemberCommentDTO> commentList;
        commentList = boardMapper.searchCommentList(boardCode);

        return commentList;
    }

    @Transactional
    public void commentNewPosting(MemberCommentDTO newComment) throws CommentPostingException {

    }
}

