package com.metavirtual.bloom.board.model.dao;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.BoardReportDTO;
import com.metavirtual.bloom.board.model.dto.MemberBoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    int selectTotalCount(Map<String, String> searchMap);

    List<BoardDTO> findAllBoard(SelectCriteria selectCriteria);

    BoardDTO boardSelectOne(int boardCode);

    int boardNewPosting(MemberBoardDTO newPosting);
    int boardModify(MemberBoardDTO modifyBoard);
    int boardDelete(MemberBoardDTO deleteBoard);


    List<MemberCommentDTO> searchCommentList(int boardCode);

    int commentPosting(MemberCommentDTO newComment);

    int commentDelete(int commentCode);

    int reportInsert(BoardReportDTO newReport);


    int viewCount(int boardCode);

    void reportCount(int boardCode);
}


