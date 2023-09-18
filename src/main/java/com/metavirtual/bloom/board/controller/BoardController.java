/*
package com.metavirtual.bloom.board.controller;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.service.BoardService;
import com.metavirtual.bloom.common.exception.board.BoardPostingException;
import com.metavirtual.bloom.common.paging.SelectCriteria;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    public String searchAllList(String searchInput, String searchValue,
                                Model model) {


        SelectCriteria selectCriteria = null;


        List<BoardDTO> boardList = boardService.findAllBoard(selectCriteria);

        model.addAttribute("boardList", boardList);

        model.addAttribute("selectCriteria", selectCriteria);

        return "board/boardPagingTest";
    }

    */
/* boardInsert.html 게시글 등록 메서드 *//*

    @PostMapping("/boardPosting")
    public String boardContentPosting(BoardDTO newPosting, RedirectAttributes rttr) throws BoardPostingException {

        boardService.boardNewPosting(newPosting);
        rttr.addFlashAttribute("successMessage", "게시글 등록에 성공하였습니다");
        return "redirect:/board/boardMain";
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

    @GetMapping("/centerInsert")
    public String centerInsert() {
        return "/board/customerInsert";
    }

    @GetMapping("/centerSelectOne")
    public String centerSelectOne() {
        return "/board/customerSelectOne";
    }

}
*/
