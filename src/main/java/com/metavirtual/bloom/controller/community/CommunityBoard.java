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

}
