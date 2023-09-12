package com.metavirtual.bloom.controller.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/communityboard")
public class CommunityBoard {

    @GetMapping("/board")
    public String community() {
        return "communityboard/communityboard";
    }

    @GetMapping("/communityinsert")
    public String communityInsert() {
        return "communityboard/communityinsert";
    }

    @GetMapping("communityboardselectone")
    public String selectOne() {
        return "communityboard/boardselectone";
    }

    @GetMapping("/singo")
    public String singo() {
        return "communityboard/singo";
    }

    @GetMapping("/singojupsu")
    public String singojupsu() {
        return "communityboard/singgjubsu";
    }

    @GetMapping("/gomin")
    public String gominSangdamSo() {
        return "/communityboard/gominSangdamSo";
    }

    @GetMapping("/gominSangdamInsert")
    public String gominInsert() {
        return "/communityboard/gominInsert";
    }


    @GetMapping("/gominselectone")
    public String gominselectone() {
        return "/communityboard/gominselectone";
    }

    @GetMapping("/gominwait")
    public String gominwait() {
        return "/communityboard/gominwait";
    }

    @GetMapping("/center")
    public String center() {
        return "/communityboard/center";
    }

    @GetMapping("/centerInsert")
    public String centerInsert() {
        return "/communityboard/centerInsert";
    }

    @GetMapping("/centerSelectOne")
    public String centerSelectOne() {
        return "/communityboard/centerSelectOne";
    }

}