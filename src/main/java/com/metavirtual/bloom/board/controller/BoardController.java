package com.metavirtual.bloom.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/boardMain")
    public String boardMain() {
        return "board/boardMain";
    }

    @GetMapping("/boardSelectOne")
    public String boardSelectOne() {
        return "board/boardSelectOne";
    }

    @GetMapping("/boardInsert")
    public String boardInsert() {
        return "board/boardInsert";
    }


    @GetMapping("/gomin")
    public String gominSangdamSo() {
        return "board/gominMain";
    }

    @GetMapping("/gominInsert")
    public String gominInsert() {
        return "board/gominInsert";
    }

    @GetMapping("/gominSelectOne")
    public String gominSelectOne() {
        return "board/gominSelectOne";
    }

    @GetMapping("/gominSelectWait")
    public String gominSelectWait() {
        return "board/gominSelectWait";
    }


    @GetMapping("/customerCenter")
    public String custConter() {
        return "board/customerCenter";
    }
    @GetMapping("/customerCenterSelectOne")
    public String customerCenterSelectOne() {
        return "board/customerCenterSelectOne";
    }
    @GetMapping("/customerCenterInsert")
    public String customerCenterInsert() {
        return "board/customerCenterInsert";
    }

    @GetMapping("/singoInsert")
    public String singoInsert() {
        return "board/singoInsert";
    }

    @GetMapping("/singoResult")
    public String singoResult() {
        return "board/singoResult";
    }
}
