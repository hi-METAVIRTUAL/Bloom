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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
            UserDTO user = memberPageService.userInfo(authentication.getName());
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
    public String changeMemberInfo(@ModelAttribute MemberInfo member, HttpServletRequest request,
                                   @RequestParam("name") String name, @RequestParam("userId") String userId,
                                   @RequestParam("nickname") String nickname, @RequestParam("phone") String phone,
                                   HttpServletResponse reponse, RedirectAttributes rttr, Model model,
                                   Authentication authentication) throws ModifyInfoException {

        if (authentication != null && authentication.isAuthenticated()) {
            UserImpl user = (UserImpl) authentication.getPrincipal();
            model.addAttribute("user", user);
        }

        log.info("");
        log.info("[MemberPageController] modifyMemberInfo ========");

        member.setName(name);
        member.setUserId(userId);
        member.setPwd(passwordEncoder.encode(member.getPwd()));
        member.setNickname(nickname);
        member.setPhone(phone);
        member.setGender(member.getGender());
        member.setEmail(request.getParameter("emailId")+"@"+request.getParameter("emailDomain"));

        log.info("[MemberPageController] modifyMemberInfo request MemberInfo : " + member );

        try {
            memberPageService.modifyMemberInfo(member);
            rttr.addFlashAttribute("infoMessage1", "개인 정보 수정에 성공하셨습니다!");
        } catch(ModifyInfoException e) {
            rttr.addFlashAttribute("infoMessage2", "❌개인 정보 수정 실패❌ 고객센터로 문의 바랍니다.");
        }

        return "redirect:/member/memberInfo";
    }

    @RequestMapping("/nickDuplCK")
    @ResponseBody
    public String checkDuplication(@RequestBody String nickname) throws ModifyInfoException{

        boolean duplicationCK = memberPageService.selectMemberByNickname(nickname);
        if (!duplicationCK){
            return "0";
        } else {
            return "1";
        }
    }

    @GetMapping("/postList")
    public ModelAndView myPost(Model model, Authentication authentication, HttpServletRequest request
                                ,@RequestParam(name = "currentPage", defaultValue = "1") int ppageNo
                                ,@RequestParam(name = "currentPage", defaultValue = "1") int cpageNo
                                ,@RequestParam(name = "currentPage", defaultValue = "1") int rpageNo
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

    @RequestMapping("/deleteMyPost")
    @ResponseBody
    public String deleteMyPost(@RequestBody int[] ajaxMsg1) throws DeleteException {

        int size = ajaxMsg1.length;
        for(int i=0; i<size; i++){
            boolean deleteSuccess1 = memberPageService.deleteMyPost(ajaxMsg1[i]);
            if (!deleteSuccess1){
                return "0";
            }
        }
        return "1";
    }

    @RequestMapping("/deleteMyComment")
    @ResponseBody
    public String deleteMyComment(@RequestBody int[] ajaxMsgC) throws DeleteException{

        int size = ajaxMsgC.length;
        for(int i=0; i<size; i++){
            boolean deleteSuccess2 = memberPageService.deleteMyComment(ajaxMsgC[i]);
            if (!deleteSuccess2){
                return "0";
            }
        }
        return "1";
    }

    @RequestMapping("/deleteMyReview")
    @ResponseBody
    public String deleteMyReview(@RequestBody int[] ajaxMsgR) throws DeleteException{

        int size = ajaxMsgR.length;
        for(int i=0; i<size; i++){
            boolean deleteSuccess3 = memberPageService.deleteMyReview(ajaxMsgR[i]);
            if (!deleteSuccess3){
                return "0";
            }
        }
        return "1";
    }
}
