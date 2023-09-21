package com.metavirtual.bloom.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.metavirtual.bloom.common.exception.myPage.UserRegistException;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
/*import com.metavirtual.bloom.user.model.service.UserServiceImpl;*/
import com.metavirtual.bloom.user.model.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserServiceImpl userService;

    @Autowired
    public UserController(PasswordEncoder passwordEncoder, UserServiceImpl userService) {
        this.passwordEncoder = passwordEncoder;
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
    public String registMember(@RequestParam String username, @RequestParam String password, @RequestParam String emailId, @RequestParam String emailDomain,
                               @ModelAttribute UserDTO user, @ModelAttribute MemberDTO member) /*throws UserRegistException*/ {


        System.out.println("[UserController] 들어옴");

        System.out.println(user + " " + member);

        user.setUserId(username);
        user.setPwd(password);
        user.setEmail(emailId + '@' + emailDomain);
        String registDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setRegistDate(registDate);
        user.setAuthority_code(1);

        member.setUserId(username);

        System.out.println("가져온 결과 = " +user.getUserId() +" " + user.getPwd() + " " + user.getEmail() + " " + user.getRegistDate()+ " " + user.getAuthority_code());
        System.out.println("총 결과 = " + user.getUserId() +" " + user.getPwd() + " " + user.getName() + " "
                + user.getGender() + " " + user.getEmail() + " " + user.getPhone() + " " + user.getRegistDate() + " " + user.getAuthority_code());

        System.out.println("멤버 결과 : " + member.getNickname());

       // userService.registUser(user,member);

        return "user/memberRegistSuccess";
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

       /* String gender.setGender("myGender")
        if ("male".equals(myGender)) {
            user.setGender('M');
        } else if ("female".equals(myGender)) {
            user.setGender('F');
        }*/

        /*user.setEmail(request.getParameter("emailId")+'@'+request.getParameter("emailDomain"));*/


        /*String emailId = request.getParameter("emailId");
        String emailDomain = request.getParameter("emailDomain");
        String email = emailId + "@" + emailDomain;*/

/*        user.setName(name);
        user.setUserId(username);
        user.setPwd(passwordEncoder.encode(user.getPwd()));*/
    }

        @PostMapping("/idDupCheck")
        @ResponseBody
        public Map<Object, Object> idDupCheck(@RequestBody String userId) throws Exception {

        System.out.println(userId);
        Map<Object,Object> map = new HashMap<Object, Object>();
        int result = 0;

        result = userService.idDupCheck(userId);
        System.out.println(result);
        map.put("check", result);
            System.out.println(userId);
        return map;
        }

        @PostMapping("/nicknameDupCheck")
        @ResponseBody
        public Map<Object, Object> nicknameDupCheck(@RequestBody String nickname) throws Exception {

            System.out.println(nickname);
            Map<Object, Object> map = new HashMap<>();
            int result = 0;

            result = userService.nicknameDupCheck(nickname);
            System.out.println(nickname);

            map.put("check", result);

            return map;
        }

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