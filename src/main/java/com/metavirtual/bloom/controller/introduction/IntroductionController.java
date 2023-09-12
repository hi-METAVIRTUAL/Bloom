package com.metavirtual.bloom.controller.introduction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/introduction")
public class IntroductionController {

    @GetMapping("/introduction")
    public String intro() {
        return "introduction/introduction";
    }
}
