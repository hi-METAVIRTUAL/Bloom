package com.metavirtual.bloom.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class CommunityBoard {

    @GetMapping("/boardMain")
    public String community() {
        return "board/boardMain";
    }

    @GetMapping("/communityinsert")
    public String communityInsert() {
        return "board/boardInsert";
    }

    @GetMapping("communityboardselectone")
    public String selectOne() {
        return "board/boardSelectOne";
    }

    @GetMapping("/singo")
    public String singo() {
        return "board/singoInsert";
    }

    @GetMapping("/singojupsu")
    public String singojupsu() {
        return "board/singoResult";
    }

    @GetMapping("/gomin")
    public String gominSangdamSo() {
        return "/board/gominMain";
    }

    @GetMapping("/gominSangdamInsert")
    public String gominInsert() {
        return "/board/gominInsert";
    }


    @GetMapping("/gominselectone")
    public String gominselectone() {
        return "/board/gominSelectOne";
    }

    @GetMapping("/gominwait")
    public String gominwait() {
        return "/board/gominSelectWait";
    }

    @GetMapping("/center")
    public String center() {
        return "/board/customerCenter";
    }

    @GetMapping("/centerInsert")
    public String centerInsert() {
        return "/board/customerCenterInsert";
    }

    @GetMapping("/centerSelectOne")
    public String centerSelectOne() {
        return "/board/customerCenterSelectOne";
    }

}