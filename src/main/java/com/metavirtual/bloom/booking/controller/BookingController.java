package com.metavirtual.bloom.booking.controller;


import com.metavirtual.bloom.booking.model.service.BookingService;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;

import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.booking.model.service.BookingService;
import com.metavirtual.bloom.common.exception.booking.ReviewDeleteException;
import com.metavirtual.bloom.common.exception.booking.ReviewInsertException;
import com.metavirtual.bloom.common.paging.Paging;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;


    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    /* 후기 조회 */
    @GetMapping("/reviewmain")
    public ModelAndView selectReviewList(@RequestParam(value="currentPage", defaultValue = "1") int pageNo,
                                         ModelAndView mv) {

        int totalBoardCount = bookingService.selectTotalCount();

        System.out.println("총 리뷰 수 : " + totalBoardCount);

        int limitPerPage = 6;

        int buttonAmount = 5;

        SelectCriteria selectCriteria;

        selectCriteria = Paging.getSelectCriteria (pageNo, totalBoardCount, limitPerPage, buttonAmount);

        List<ReviewDTO> reviewList = bookingService.findAllReview(selectCriteria);
        mv.addObject("reviewList", reviewList);
        mv.addObject("selectCriteria", selectCriteria);
        
        System.out.println("가져온 후기 리스트? : " + reviewList);
        
        mv.setViewName("booking/reviewmain");
        return mv;
    }

    @GetMapping("/reservation")
    public ModelAndView reservationPage(ModelAndView mv, @RequestParam("userId") String therapistId){

        System.out.println("booking controller: "+ therapistId);

        mv.addObject("therapistId", therapistId);
        mv.setViewName("/booking/reservation");

        return mv;
    }

    @PostMapping(value = "/makeReservation", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String receiveReservationDateTime(@RequestParam("selectedDateTime") String selectedDateTime
                                             ,@AuthenticationPrincipal User authenticatedUser
                                            ,@RequestParam("therapistId") String therapistId, Model model) {

        System.out.println("makeReservation controller");
        String userId = authenticatedUser.getUsername();
        model.addAttribute(therapistId);
        System.out.println(userId +"11");

        System.out.println("Received selectedDateTime : " + selectedDateTime + " member: " + userId + " therapist: " + therapistId);

       bookingService.makeBooking(therapistId, userId, selectedDateTime);
        return "index";
    }

    /* 후기 등록 화면 */
    @GetMapping("/reviewPosting")
    public String reviewPosting() {
        return "booking/reviewInsert";
    }


    /* 후기 등록 메서드 */
    @PostMapping("/reviewPosting")
    public String reviewPosting(@RequestParam int reviewScore, @ModelAttribute ReviewDTO newReview, RedirectAttributes rttr) throws ReviewInsertException {

        System.out.println("파라미터 값? : " + newReview);

        if(reviewScore != 0) {
            bookingService.newReviewPosting(newReview);
            rttr.addFlashAttribute("message", "후기 등록에 성공하였습니다.");
        } else {
            rttr.addFlashAttribute("message", "후기 등록에 실패하였습니다. 평점을 매겨주세요.");
        }
        return "redirect:/booking/reviewmain";
    }



    /* 후기 삭제 메서드 */
    @PostMapping("/reviewDelete")
    public String reviewDelete(@ModelAttribute ReviewDTO deleteReview, RedirectAttributes rttr) throws ReviewDeleteException {

        bookingService.reviewDelete(deleteReview);
        rttr.addFlashAttribute("message", "후기가 삭제되었습니다");

        return "redirect:/booking/reviewmain";
    }
}
