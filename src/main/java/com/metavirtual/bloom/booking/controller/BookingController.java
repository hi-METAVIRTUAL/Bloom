package com.metavirtual.bloom.booking.controller;

import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.common.exception.board.ReportInsertException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @GetMapping("/reviewmain")
    public String review() {
        return "booking/reviewmain";
    }

    @GetMapping("/reservation")
    public String reservationPage(){
        return "booking/reservation";
    }
/*
    @PostMapping("/reviewPosting")
    public String reviewPosting(@ModelAttribute ReviewDTO newReview, RedirectAttributes rttr) throws ReviewInsertException {

        String aa = '1234';
        System.out.println("신고 파라미터 값 : " + newReview);
        if(aa != null && aa != "") {
            boardService.reviewInsert(newReview);
            rttr.addFlashAttribute("message", "후기가 등록되었습니다.");
        } else {
            rttr.addFlashAttribute("message", "후기가 등록되지 않았습니다. 신고사유 카테고리중 하나를 선택해주세요.");
        }
        return "redirect:/board/searchList";
    }*/
}
