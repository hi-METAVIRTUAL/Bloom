/*

package com.metavirtual.bloom.board.model.service;

import com.metavirtual.bloom.board.model.dao.BoardMapper;
import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.common.exception.board.BoardPostingException;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }


    */
/* 전체 게시글 조회 메서드 *//*

    public List<BoardDTO> findAllBoard(SelectCriteria selectCriteria) {
        List<BoardDTO> boardList = boardMapper.findAllBoard(selectCriteria);

        return boardList;
    }


    */
/* boardInsert.html 게시글 등록 메서드 *//*

    @Transactional
    public void boardNewPosting(BoardDTO newPosting) throws BoardPostingException {
        int result = boardMapper.boardNewPosting(newPosting);

        if(!(result > 0)) {
            throw new BoardPostingException("게시글 등록에 실패하였습니다");
        }
    }

}

*/
