package com.metavirtual.bloom.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @GetMapping("/reviewmain")
    public String review() {
        return "reviewboard/reviewmain";
    }

    @GetMapping("reservation")
    public String reservationPage(){
        return "booking/reservation";
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
