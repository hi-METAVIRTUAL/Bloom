package com.metavirtual.bloom.booking.controller;

import com.metavirtual.bloom.booking.model.service.BookingService;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/reviewmain")
    public String review() {
        return "booking/reviewmain";
    }

    @GetMapping("/reservation")
    public String reservationPage(Model model, @RequestParam("therapistId") String therapistId){

        System.out.println("booking controller: "+ therapistId);

        model.addAttribute(therapistId);
        return "/booking/reservation";
    }

    @PostMapping(value = "/makeReservation", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String receiveReservationDateTime(@RequestParam("selectedDateTime") String selectedDateTime
                                             ,@AuthenticationPrincipal User authenticatedUser
                                            ,@RequestParam("therapistId") String therapistId, Model model) {

        System.out.println("makeReservation controller");
        System.out.println(therapistId);
        String userId = authenticatedUser.getUsername();
        model.addAttribute(therapistId);

        System.out.println("Received selectedDateTime : " + selectedDateTime + " member: " + userId + " therapist: " + therapistId);

       bookingService.makeBooking(therapistId, userId, selectedDateTime);
        return "index";
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
