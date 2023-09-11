package com.metavirtual.bloom.controller.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class CommunityBoard {

    @GetMapping("/communityboard")
    public String community() {
        return "communityboard/communityboard";
    }

}
