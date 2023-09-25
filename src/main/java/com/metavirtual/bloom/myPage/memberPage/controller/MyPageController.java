package com.metavirtual.bloom.myPage.memberPage.controller;

import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;
import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.booking.model.dto.ReviewDTO;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {

    @GetMapping("/memberInfo")
    public String memberInfo(Model model, Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()){
            UserDTO user = (UserDTO) authentication.getPrincipal();
            model.addAttribute("user", user);

            BookingDTO booking = (BookingDTO) authentication.getPrincipal();
            model.addAttribute("booking", booking);
        }
        return "memberInfo";
    }

    @GetMapping("/modifyMemberInfo")
    public String modifyMemberInfo(Model model, Authentication authentication){
        if(authentication != null && authentication.isAuthenticated()){
            UserDTO user = (UserDTO) authentication.getPrincipal();
            model.addAttribute("user", user);

            MemberDTO member = (MemberDTO) authentication.getPrincipal();
            model.addAttribute("member", member);
        }
        return "modifyMemberInfo";
    }

    @GetMapping("/postList")
    public String postList(Model model, Authentication authentication){
        if(authentication != null && authentication.isAuthenticated()){
            UserDTO user = (UserDTO) authentication.getPrincipal();
            model.addAttribute("user", user);

            BoardDTO board = (BoardDTO) authentication.getPrincipal();
            model.addAttribute("board", board);

            MemberCommentDTO memberComment = (MemberCommentDTO) authentication.getPrincipal();
            model.addAttribute("memberComment", memberComment);

            ReviewDTO review = (ReviewDTO) authentication.getPrincipal();
            model.addAttribute("review", review);

            BookingDTO booking = (BookingDTO) authentication.getPrincipal();
            model.addAttribute("booking", booking);

            SelectCriteria selectCriteria = (SelectCriteria) authentication.getPrincipal();
            model.addAttribute("selectCriteria", selectCriteria);
        }
        return "postList";
    }
}
