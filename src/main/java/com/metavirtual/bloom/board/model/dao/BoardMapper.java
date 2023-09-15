package com.metavirtual.bloom.board.model.dao;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDTO> findAllBoard(SelectCriteria selectCriteria);

    int boardNewPosting(BoardDTO newPosting);
}


