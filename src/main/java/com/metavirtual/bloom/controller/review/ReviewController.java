package com.metavirtual.bloom.controller.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @GetMapping("/reviewmain")
    public String review() {
        return "reviewboard/reviewmain";
    }

    /*
    public ModelAndView boardCount(ModelAndView mv) {

        SelectCriteria selectCriteria = new SelectCriteria(1, 5, 1);
        mv.addObject(selectCriteria);
        mv.setViewName("/reviewboard/reviewcriteria");

        return mv;
    }
*/
}
