package com.metavirtual.bloom.board.model.dao;

import com.metavirtual.bloom.board.model.dto.*;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dto.TherapistCommentListDTO;
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

    List<TherapistCommentListDTO> searchTherapistComment(int boardCode);

    int therapistComment(TherapistCommentListDTO newTherapistComment);

    TherapistCommentListDTO counselSelectOne(int boardCode);
}


