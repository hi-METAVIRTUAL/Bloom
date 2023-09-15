package com.metavirtual.bloom.board.model.service;

import com.metavirtual.bloom.board.model.dao.BoardMapper;
import com.metavirtual.bloom.board.model.dto.BoardDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<BoardDTO> searchAllBoard() {
        return BoardMapper.searchAllBoard();
    }
}
