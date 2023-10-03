package com.metavirtual.bloom.board.controller;

import com.metavirtual.bloom.board.model.service.CustomerService;
import com.metavirtual.bloom.common.exception.board.CustomerInsertException;
import com.metavirtual.bloom.common.paging.Paging;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.adminPage.model.dto.AdminCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

/*

    @GetMapping(value = "/customerList")
    public ModelAndView searchAlCustomerComment(@RequestParam(value="currentPage", defaultValue = "1") int pageNo,
                                      ModelAndView mv) {
        int limitPerPage = 10;

        int buttonAmount = 5;

        int totalBoardCount = customerService.selectTotalCount();

        System.out.println("총 문의글 수 : " + totalBoardCount);

        SelectCriteria selectCriteria;

        selectCriteria = Paging.getSelectCriteria (pageNo, totalBoardCount, limitPerPage, buttonAmount);

        List<AdminCommentDTO> customerComment = customerService.findAllCustomerComment(selectCriteria);

        mv.addObject("customerComment", customerComment);
        mv.addObject("selectCriteria", selectCriteria);

        System.out.println("가져온 문의글 리스트? : " + customerComment);
        System.out.println("조회리스트에 따른 페이징 처리는? : " + selectCriteria);

        mv.setViewName("board/customerCenter");

        return mv;
    }

    @GetMapping("/customerSelectOne")
    public String customerSelectOne (HttpServletRequest request, Model model) {

        int boardCode = Integer.valueOf(request.getParameter("boardCode"));
        AdminCommentDTO selectOne = customerService.customerSelectOne(boardCode);
        System.out.println("디테일 가져오는지? : " + selectOne);

        model.addAttribute("board", selectOne);
        return "board/customerSelectOne";
    }

    @GetMapping("/customerInsert")
    public String customerInsert() {
        return "board/customerInsert";
    }


    @PostMapping("/customerInsert")
    public String customerInsert(@RequestParam String commentContent
            , @ModelAttribute AdminCommentDTO newInsert, RedirectAttributes rttr) throws CustomerInsertException {

        System.out.println("파라미터 값? : " + newInsert);

        if(commentContent != "") {
            customerService.customerNewInsert(newInsert);
            rttr.addFlashAttribute("message", "문의글 등록에 성공하였습니다.");
        } else if (commentContent == "") {
            rttr.addFlashAttribute("message", "문의글 등록에 실패하였습니다. 문의내용을 입력해주세요.");
        }

        return "redirect:/board/customerCenter";
    }

*/


}
