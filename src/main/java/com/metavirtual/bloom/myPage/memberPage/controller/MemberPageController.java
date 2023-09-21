package com.metavirtual.bloom.myPage.memberPage.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.metavirtual.bloom.board.model.dto.BoardDTO;
import com.metavirtual.bloom.board.model.dto.MemberCommentDTO;
import com.metavirtual.bloom.common.exception.myPage.DeleteException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.Paging;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.memberPage.model.dto.CommentListDTO;
import com.metavirtual.bloom.myPage.memberPage.model.dto.ReviewListDTO;
import com.metavirtual.bloom.myPage.memberPage.model.service.MemberPageService;
import com.metavirtual.bloom.myPage.memberPage.model.service.MemberPageServiceImpl;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import com.metavirtual.bloom.user.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
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
    public String memberInfo (){
        return "mypage/member/memberInfo";
    }

    @GetMapping("/modifyMemberInfo")
    public String modifyMemberInfo(){
        return "mypage/member/modifyMemberInfo";
    }

    @PostMapping("/modifyMemberInfo")
    public String changeMemberInfo(@ModelAttribute MemberDTO member, UserDTO user, HttpServletRequest request, HttpServletResponse reponse, RedirectAttributes rttr) throws ModifyInfoException {
        log.info("");
        log.info("");
        log.info("[MemberPageController] modifyMemberInfo ========");

        user.setPwd(passwordEncoder.encode(user.getPwd()));
        user.setEmail(request.getParameter("emailId")+"@"+request.getParameter("emailDomain"));
        member.setNickname(member.getNickname());
        user.setPhone(request.getParameter("phonef")+"-"+request.getParameter("phonem")+"-"+request.getParameter("phonel"));

        log.info("[MemberPageController] modifyMemberInfo request Member, User : " + member + user);

        memberPageService.modifyMemberInfo(member, user);

        rttr.addFlashAttribute("message", "개인 정보 수정에 성공하셨습니다!");

        return "redirect:/mypage/member/memberInfo";
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

    @GetMapping("/postList")
    public String postList(){
        return "mypage/member/postList";
    }

    @GetMapping(value = "/myPost")
    public ModelAndView myPost(HttpServletRequest request
                                ,@RequestParam(value = "currentPage", defaultValue = "1") int pageNo
                               ,ModelAndView mv){

        log.info("");
        log.info("");
        log.info("[MemberPageController] ========");

//        Map<String, String> searchMap = new HashMap<>();
//        searchMap.put("searchCondition", searchCondition);
//        searchMap.put("searchValue", searchValue);
//
//        log.info("[MemberPageController] 컨트롤러에서 검색조건 확인하기 : " +searchMap);

        int totalPostCount = memberPageService.selectTotalPostCount();
        int totalCommentCount = memberPageService.selectTotalCommentCount();
        int totalReviewCount = memberPageService.selectTotalReviewCount();
        log.info("[MemberPageController] totalMyPostCount : "+totalPostCount);
        log.info("[MemberPageController] totalMyPostCount : "+totalCommentCount);
        log.info("[MemberPageController] totalMyPostCount : "+totalReviewCount);

        int limitPerPage = 5;

        int buttonAmount = 5;

        SelectCriteria selectCriteria1 = Paging.getSelectCriteria(pageNo, totalPostCount, limitPerPage, buttonAmount);
        SelectCriteria selectCriteria2 = Paging.getSelectCriteria(pageNo, totalCommentCount, limitPerPage, buttonAmount);
        SelectCriteria selectCriteria3 = Paging.getSelectCriteria(pageNo, totalReviewCount, limitPerPage, buttonAmount);

//        if(searchCondition != null && !"".equals(searchCondition)){
//            selectCriteria = Paging.getSelectCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount, searchCondition, searchValue);
//        } else {
//            selectCriteria = Paging.getSelectCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount);
//        }

        log.info("[MemberPageController] selectCriteria : "+selectCriteria1);
        log.info("[MemberPageController] selectCriteria : "+selectCriteria2);
        log.info("[MemberPageController] selectCriteria : "+selectCriteria3);

        List<BoardDTO> myPostList = memberPageService.selectPostList(selectCriteria1);
        List<CommentListDTO> myCommentList = memberPageService.selectCommentList(selectCriteria2);
        List<ReviewListDTO> myReviewList = memberPageService.selectReviewList(selectCriteria3);

        log.info("[MemberPageController] myPostList : "+myPostList);
        log.info("[MemberPageController] myCommentList : "+myCommentList);
        log.info("[MemberPageController] myReviewList : "+myReviewList);

        mv.addObject("myPostList", myPostList);
        mv.addObject("myCommentList", myCommentList);
        mv.addObject("myReviewList", myReviewList);
        mv.addObject("selectCriteria", selectCriteria1);
        mv.addObject("selectCriteria", selectCriteria2);
        mv.addObject("selectCriteria", selectCriteria3);
        log.info("[MemberPageController] selectCriteria : "+selectCriteria1);
        log.info("[MemberPageController] selectCriteria : "+selectCriteria2);
        log.info("[MemberPageController] selectCriteria : "+selectCriteria3);
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
