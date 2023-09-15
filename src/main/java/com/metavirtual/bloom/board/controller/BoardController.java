/*
package com.metavirtual.bloom.board.controller;

import com.metavirtual.bloom.board.model.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "board/communityboard";
    }

    */
/*@GetMapping("/search")*//*



    @GetMapping("/communityInsert")
    public String communityInsert() {
        return "board/communityInsert";
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
        return "board/gominselectone";
    }

    @GetMapping("/gominwait")
    public String gominwait() {
        return "board/gominwait";
    }

    @GetMapping("/center")
    public String center() {
        return "board/center";
    }

    @GetMapping("/centerInsert")
    public String centerInsert() {
        return "board/centerInsert";
    }

    @GetMapping("/centerSelectOne")
    public String centerSelectOne() {
        return "board/centerSelectOne";
    }

}*/
