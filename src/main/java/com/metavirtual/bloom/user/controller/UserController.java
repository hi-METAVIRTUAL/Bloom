package com.metavirtual.bloom.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.metavirtual.bloom.common.exception.member.UserRegistException;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
/*import com.metavirtual.bloom.user.model.service.UserServiceImpl;*/
import com.metavirtual.bloom.user.model.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
//    private final PasswordEncoder passwordEncoder;
    private final UserServiceImpl userService;

    @Autowired
    public UserController(/*PasswordEncoder passwordEncoder,*/ UserServiceImpl userService) {
        /*this.passwordEncoder = passwordEncoder;*/
        this.userService = userService;
    }

    @GetMapping("/category")
    public String regist(){
        return "user/registCategory";
    }

    @GetMapping("/memberRegist")
    public String regularRegist(){
        return "user/memberRegist";
    }

    @PostMapping("/memberRegist") //spring 에서 제공하는 다른 request 써
    public String registMember(@ModelAttribute UserDTO user, @ModelAttribute MemberDTO member, HttpServletRequest request) throws UserRegistException {


        System.out.println(user + " " + member);
        /*user.setName(request.getParameter("name"));
        user.setUserId(request.getParameter("username"));
        user.setPwd(passwordEncoder.encode(user.getPwd()));
        member.setNickname("nickname");
        user.setPhone(request.getParameter("phonef")+"-"+ request.getParameter("phonem")+"-"+request.getParameter("phonel"));

        String registDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setRegistDate(registDate);*/

        /* String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");
        String phone1 = request.getParameter("phonef");
        String phone2 = request.getParameter("phonem");
        String phone3 = request.getParameter("phonel");
        String phone = phone1 + "-" + phone2 + "-" + phone3;*/

        String myGender = request.getParameter("myGender");
        if ("male".equals(myGender)) {
            user.setGender('M');
        } else if ("female".equals(myGender)) {
            user.setGender('F');
        }

        user.setEmail(request.getParameter("emailId")+'@'+request.getParameter("emailDomain"));

        userService.registUser(user,member);

        return "user/memberRegistSuccess";
        /*String emailId = request.getParameter("emailId");
        String emailDomain = request.getParameter("emailDomain");
        String email = emailId + "@" + emailDomain;*/

/*        user.setName(name);
        user.setUserId(username);
        user.setPwd(passwordEncoder.encode(user.getPwd()));*/
    }

    @PostMapping("/user/idDupCheck")
    public ResponseEntity<String> idDupCheck(@RequestBody UserDTO userDTO) {
        System.out.println("controllerTest1");
        String result = "사용 가능한 아이디 입니다.";

        if (userDTO != null && userService.idDupCheck(userDTO.getUserId())) {
            result = "이미 사용 중인 아이디입니다";
        }

        return ResponseEntity.ok(result);
    }


    // Replace this method with your actual duplicate check logic
    private boolean isUsernameDuplicate(String username) {
        // Implement your logic here to check if the username is a duplicate.
        // Return true if it's a duplicate, false if it's not.
        // You can use a service or repository to check against your data source.
        // For now, we assume it's not a duplicate.
        return false;
    }

/*    @PostMapping ("/nicknameDupCheck")
    public ResponseEntity<String> nicknameDupCheck(@RequestBody MemberDTO memberDTO) throws JsonProcessingException {
        log.info("[UserController] nicknameDupCheck");

        String result = "사용 가능한 닉네임 입니다";
        log.info("[UserController] nicknameDupCheck : " + memberDTO.getNickname());

        if("".equals(memberDTO.getNickname())) {
            log.info("[UserController] nickname - No value inputed");
            result = "닉네임을 입력해주세요";
        } else if(userService.selectUserByNickname(memberDTO.getNickname())) {
            log.info("[UserController] nickname - Already exists");
            result = "중복돤 닉네임이 존재합니다";
        }

        return ResponseEntity.ok(result);
    }*/

    @PostMapping("/memberRegistSuccess")
    public String regularRegistSuccess() {
        return "user/memberRegistSuccess"; }

    @GetMapping("/therapistRegist")
    public String therapistRegist(){
        return "user/therapistRegist";
    }

    @GetMapping("/therapistRegist2")
    public String therapistRegist2(){
        return "user/therapistRegist2";
    }

    @GetMapping("/therapistRegistSuccess")
    public String therapistRegistSuccess() { return "user/therapistRegistSuccess"; }


    @GetMapping("/login")
    public String login() { return "user/login"; }

    @GetMapping("/findId")
    public String findId() { return "user/findId"; }

    @GetMapping("/findPassword")
    public String findPassword() {
        return "user/findPassword";
    }

    @GetMapping("/verificationIdSent")
    public String idSentToEmail() { return "user/verificationIdsent"; }

    @GetMapping("verificationPasswordSent")
    public String passwordSentToEmail() { return "user/verificationPasswordSent"; }
}
/**/