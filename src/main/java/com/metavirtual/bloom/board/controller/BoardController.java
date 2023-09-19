/*
package com.metavirtual.bloom.board.controller;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;
import com.metavirtual.bloom.board.model.service.BoardService;
import com.metavirtual.bloom.common.exception.board.BoardPostingException;
import com.metavirtual.bloom.common.exception.board.CommentPostingException;
import com.metavirtual.bloom.common.paging.Paging;
import com.metavirtual.bloom.common.paging.SelectCriteria;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/communityboard")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @GetMapping("/board")
    public String community() {
        return "/board/boardMain";
    }

    */
/* 전체 게시글 조회 메서드 *//*

    @GetMapping("/searchList")
    public String searchAllList(HttpServletRequest request, @RequestParam String searchSelect, @RequestParam String searchValue, @RequestParam(value="currentPage", defaultValue = "1") int pageNo,
                                Model model) {


        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchSelect", searchSelect);
        searchMap.put("searchValue", searchValue);

        int totalBoardCount = boardService.selectTotalCount(searchMap);

        int limitPerPage = 10;

        int buttonAmount = 5;

        SelectCriteria selectCriteria;

        if(searchSelect != null && !"".equals(searchSelect)) {
            selectCriteria = Paging.getSelectCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount, searchSelect, searchValue);
        } else {
            selectCriteria = Paging.getSelectCriteria (pageNo, totalBoardCount, limitPerPage, buttonAmount);
        }

        List<BoardDTO> boardList = boardService.findAllBoard(selectCriteria);

        model.addAttribute("boardList", boardList);
        model.addAttribute("selectCriteria", selectCriteria);

        return "board/boardPagingTest";
    }


    /* 게시글 상세 조회 */
    @GetMapping("/")
    public String boardSelectOne (HttpServletRequest request, Model model) {
        int boardCode = Integer.valueOf(request.getParameter("boardCode"));
        BoardDTO boardOne = boardService.boardSelectOne(boardCode);

        model.addAttribute("board", boardOne);

        /* 댓글 조회 */
        List<MemberCommentDTO> commentList = boardService.searchAllComment(boardCode);
        model.addAttribute("commentList", commentList);

        return "board/boardSelectOne";
    }

    /* 게시글 등록 메서드 */

    @PostMapping("/boardPosting")
    public String boardContentPosting(BoardDTO newPosting, RedirectAttributes rttr) throws BoardPostingException {

        boardService.boardNewPosting(newPosting);
        rttr.addFlashAttribute("successMessage", "게시글 등록에 성공하였습니다");
        return "redirect:/board/boardMain";
    }

    /* 댓글 등록 메서드 */
    @PostMapping("/commentPosting")
    public String commentContentPosting(MemberCommentDTO newPosting, RedirectAttributes rttr) throws CommentPostingException {

        boardService.commentNewPosting(newPosting);
        rttr.addFlashAttribute("successMessage", "댓글 등록에 성공하였습니다");
        return "redirect:/board/boardSelectOne";
    }


    @GetMapping("/communityInsert")
    public String communityInsert() {
        return "/board/boardInsert";
    }

    @GetMapping("boardSelectOne")
    public String selectOne() {
        return "/board/boardSelectOne";
    }

    @GetMapping("/singo")
    public String singo() {
        return "board/singo";
    }

    @GetMapping("/singoResult")
    public String singojupsu() {
        return "board/singoResult";
    }

    @GetMapping("/gomin")
    public String gominSangdamSo() {
        return "board/gominMain";
    }

    @GetMapping("/gominInsert")
    public String gominInsert() {
        return "board/gominInsert";
    }


    @GetMapping("/gominselectone")
    public String gominselectone() {
        return "/board/gominSelectOne";
    }

    @GetMapping("/gominwait")
    public String gominwait() {
        return "/board/gominWait";
    }

    @GetMapping("/center")
    public String center() {
        return "/board/customerCenter";
    }

    @GetMapping("/customerInsert")
    public String centerInsert() {
        return "/board/customerInsert";
    }

    @GetMapping("/customerSelectOne")
    public String centerSelectOne() {
        return "/board/customerSelectOne";
    }

}
*/
