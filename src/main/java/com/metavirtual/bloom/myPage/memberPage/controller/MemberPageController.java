package com.metavirtual.bloom.myPage.memberPage.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;
import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.common.exception.myPage.DeleteException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.Paging;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.memberPage.model.dto.*;
import com.metavirtual.bloom.myPage.memberPage.model.service.MemberPageService;
import com.metavirtual.bloom.myPage.memberPage.model.service.MemberPageServiceImpl;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import com.metavirtual.bloom.user.model.dto.UserImpl;
import com.metavirtual.bloom.user.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberPageController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final PasswordEncoder passwordEncoder;
    private final MemberPageServiceImpl memberPageService;


    public MemberPageController(PasswordEncoder passwordEncoder, MemberPageServiceImpl memberPageService){
        this.passwordEncoder = passwordEncoder;
        this.memberPageService = memberPageService;
    }


    @GetMapping("/memberInfo")
    public String memberInfo (Model model, Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()) {
            UserImpl user = (UserImpl) authentication.getPrincipal();
            model.addAttribute("user", user);

            MemberBookingInfo booking = memberPageService.memberBookingInfo(authentication.getName());
            model.addAttribute("booking", booking);
        }

        return "mypage/member/memberInfo";
    }

    @GetMapping("/modifyMemberInfo")
    public String modifyMemberInfo(Model model, Authentication authentication){
        if(authentication != null && authentication.isAuthenticated()){
            UserImpl user = (UserImpl) authentication.getPrincipal();
            model.addAttribute("user", user);

            MemberInfo member = memberPageService.memberInfo(authentication.getName());
            model.addAttribute("member", member);
        }
        return "mypage/member/modifyMemberInfo";
    }

    @PostMapping("/modifyMemberInfo")
    public String changeMemberInfo(@ModelAttribute MemberInfo member, HttpServletRequest request, HttpServletResponse reponse, RedirectAttributes rttr, Model model, Authentication authentication) throws ModifyInfoException {

        if (authentication != null && authentication.isAuthenticated()) {
            UserImpl user = (UserImpl) authentication.getPrincipal();
            model.addAttribute("user", user);
        }

        log.info("");
        log.info("");
        log.info("[MemberPageController] modifyMemberInfo ========");

        member.setName(member.getName());
        member.setUserId(member.getUserId());
        member.setPwd(passwordEncoder.encode(member.getPwd()));
        member.setNickname(member.getNickname());
        member.setPhone(member.getPhone());
        member.setGender(member.getGender());
        member.setEmail(request.getParameter("emailId")+"@"+request.getParameter("emailDomain"));

        log.info("[MemberPageController] modifyMemberInfo request MemberInfo : " + member );

        memberPageService.modifyMemberInfo(member);

        rttr.addFlashAttribute("message", "개인 정보 수정에 성공하셨습니다!");

        return "/mypage/member/memberInfo";
    }

    @PostMapping("/nickDuplCK")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO memberDTO) throws JsonProcessingException{
        log.info("");
        log.info("");
        log.info("[MemberPageController] checkDuplication ========");

        String result = "⭕ 사용 가능한 닉네임입니다";
        log.info("[MemberPageController] Request Check NICKNAME : "+memberDTO.getNickname());

        if("".equals(memberDTO.getNickname())){
            log.info("[MemberPageController] No Input Member NICKNAME");
            result = "❗ 닉네임을 입력해 주세요";
        }else if(memberPageService.selectMemberByNickname(memberDTO.getNickname())){
            log.info("[MemberPageController] Already Exist");
            result = "❌ 중복된 닉네임입니다";
        }
        log.info("[MemberPageController] checkDuplication ========");
        return ResponseEntity.ok(result);
    }

//    @GetMapping("/postList")
//    public String postList(Model model, Authentication authentication,HttpServletRequest request
//                            , @RequestParam(value = "currentPage", defaultValue = "1") int pageNo, ModelAndView mv){
//
//        if(authentication != null && authentication.isAuthenticated()){
//            UserImpl user = (UserImpl) authentication.getPrincipal();
//            model.addAttribute("user", user);
//
//            MemberBoard board = memberPageService.memberAllBoard(authentication.getName());
//            model.addAttribute("board", board);
//        }
//
//        return "mypage/member/postList";
//    }

    @GetMapping("/postList")
    public ModelAndView myPost(Model model, Authentication authentication, HttpServletRequest request
                                ,@RequestParam(name = "pcurrentPage", defaultValue = "1") int ppageNo
                                ,@RequestParam(name = "ccurrentPage", defaultValue = "1") int cpageNo
                                ,@RequestParam(name = "rcurrentPage", defaultValue = "1") int rpageNo
                               ,ModelAndView mv){

        if(authentication != null && authentication.isAuthenticated()) {
            UserImpl user = (UserImpl) authentication.getPrincipal();
            model.addAttribute("user", user);
        }

        log.info("");
        log.info("");
        log.info("[MemberPageController] ========");

        int totalPostCount = memberPageService.selectTotalPostCount(authentication.getName());
        int totalCommentCount = memberPageService.selectTotalCommentCount(authentication.getName());
        int totalReviewCount = memberPageService.selectTotalReviewCount(authentication.getName());
        log.info("[MemberPageController] totalMyPostCount : "+totalPostCount);
        log.info("[MemberPageController] totalMyCommentCount : "+totalCommentCount);
        log.info("[MemberPageController] totalMyReviewCount : "+totalReviewCount);

        int limitPerPage1 = 5;
        int buttonAmount1 = 5;

        int limitPerPage2 = 5;
        int buttonAmount2 = 5;

        int limitPerPage3 = 5;
        int buttonAmount3 = 5;

        SelectCriteria selectCriteria1 = Paging.getSelectCriteria(ppageNo, totalPostCount, limitPerPage1, buttonAmount1);
        SelectCriteria selectCriteria2 = Paging.getSelectCriteria(cpageNo, totalCommentCount, limitPerPage2, buttonAmount2);
        SelectCriteria selectCriteria3 = Paging.getSelectCriteria(rpageNo, totalReviewCount, limitPerPage3, buttonAmount3);

        log.info("[MemberPageController] selectCriteria1 : "+selectCriteria1);
        log.info("[MemberPageController] selectCriteria2 : "+selectCriteria2);
        log.info("[MemberPageController] selectCriteria3 : "+selectCriteria3);

        List<BoardDTO> myPostList = memberPageService.selectPostList(selectCriteria1, authentication.getName());
        List<CommentListDTO> myCommentList = memberPageService.selectCommentList(selectCriteria2, authentication.getName());
        List<ReviewListDTO> myReviewList = memberPageService.selectReviewList(selectCriteria3, authentication.getName());

        log.info("[MemberPageController] myPostList : "+myPostList);
        log.info("[MemberPageController] myCommentList : "+myCommentList);
        log.info("[MemberPageController] myReviewList : "+myReviewList);

        mv.addObject("myPostList", myPostList);
        mv.addObject("myCommentList", myCommentList);
        mv.addObject("myReviewList", myReviewList);
        mv.addObject("selectCriteria1", selectCriteria1);
        mv.addObject("selectCriteria2", selectCriteria2);
        mv.addObject("selectCriteria3", selectCriteria3);
        log.info("[MemberPageController] selectCriteria1 : "+selectCriteria1);
        log.info("[MemberPageController] selectCriteria2 : "+selectCriteria2);
        log.info("[MemberPageController] selectCriteria3 : "+selectCriteria3);
        mv.setViewName("mypage/member/postList");

        log.info("[MemberPageController] ========");
        return mv;
    }

    @RequestMapping(value="/deleteMyPost")
    public String deleteMyPost(HttpServletRequest request) throws DeleteException {

        String[]ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i=0; i<size; i++){
            memberPageService.deleteMyPost(ajaxMsg[i]);
        }
        return "redirect:/mypage/member/postList";
    }

    @RequestMapping("/deleteMyComment")
    public String deleteMyComment(HttpServletRequest request) throws DeleteException{

        String[]ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i=0; i<size; i++){
            memberPageService.deleteMyComment(Integer.parseInt(ajaxMsg[i]));
        }
        return "redirect:/mypage/member/postList";
    }

    @RequestMapping("/deleteMyReview")
    public String deleteMyReview(HttpServletRequest request) throws DeleteException{

        String[]ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i=0; i<size; i++){
            memberPageService.deleteMyReview(Integer.parseInt(ajaxMsg[i]));
        }
        return "redirect:/mypage/member/postList";
    }
}
