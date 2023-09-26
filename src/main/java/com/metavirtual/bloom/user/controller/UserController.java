package com.metavirtual.bloom.user.controller;

//import com.metavirtual.bloom.common.exception.myPage.UserRegistException;
import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.common.exception.member.UserRegistException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.DataFileDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
/*import com.metavirtual.bloom.user.model.service.UserServiceImpl;*/
import com.metavirtual.bloom.user.model.dto.UserImpl;
import com.metavirtual.bloom.user.model.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
        /*import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("/login")
    public void login() {
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam("username") String userId, @RequestParam("password") String pwd, HttpServletRequest request) {
//            userService.loadUserByUsername(userId, pwd,)

        return "redirect:/";
    }
    private final PasswordEncoder passwordEncoder;
    private final UserServiceImpl userService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ServletContext servletContext; // Inject ServletContext

    @Autowired
    public UserController(PasswordEncoder passwordEncoder, UserServiceImpl userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/category")
    public String regist(){
        return "user/registCategory";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/memberRegist")
    public String regularRegist(){
        return "user/memberRegist";
    }

    @PostMapping("/memberRegist") //spring 에서 제공하는 다른 request 써
    public String registMember(@RequestParam String username, @RequestParam String password, @RequestParam String emailId, @RequestParam String emailDomain,
                               @ModelAttribute UserDTO user, @ModelAttribute MemberDTO member) throws UserRegistException {


        System.out.println("[UserController] 들어옴");

        System.out.println(user + " " + member);

        user.setUserId(username);
        user.setPwd(passwordEncoder.encode(password));
        user.setEmail(emailId + '@' + emailDomain);
        String registDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setRegistDate(registDate);
        user.setAuthorityCode(1);

        member.setUserId(username);

        System.out.println("유저 가져온 결과 = " + user.getUserId() + " " + user.getPwd() + " " + user.getEmail() + " " + user.getRegistDate() + " " + user.getAuthorityCode());
        System.out.println("총 결과 = " + user.getUserId() + " " + user.getPwd() + " " + user.getName() + " "
                + user.getGender() + " " + user.getEmail() + " " + user.getPhone() + " " + user.getRegistDate() + " " + user.getAuthorityCode());

        System.out.println("멤버 결과 : " + member.getNickname());


        try {
            userService.registUser(user, member);
        } catch (UserRegistException e) {
            throw new RuntimeException(e);
        }


        return "user/memberRegistSuccess";
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


    @PostMapping("/emailDupCheck")
    @ResponseBody
    public Map<Object, Object> emailDupCheck(@RequestBody String email) throws Exception {

        System.out.println(email);
        Map<Object,Object> map = new HashMap<Object, Object>();
        int result = 0;
        log.info(email);

        result = userService.emailDupCheck(email);
        System.out.println(result);
        map.put("check", result);
        System.out.println(email);
        return map;
    }
    @PostMapping("/memberRegistSuccess")
    public String regularRegistSuccess() {
        return "user/memberRegistSuccess"; }

    @GetMapping("/therapistRegist")
    public String registTherapist(){

        return "/user/therapistRegist";
    }


    @PostMapping("/therapistRegist")
    public String therapistRegist(@RequestParam String username, @RequestParam String password, @RequestParam String emailId
            , @RequestParam String emailDomain, @RequestParam("therapistFiles") List<MultipartFile> therapistFiles
            ,@RequestParam(value="depressionCK", defaultValue = "N") String depressionCK
            ,@RequestParam(value="anxietyCK", defaultValue = "N") String anxietyCK
            ,@RequestParam(value="bipolarCK", defaultValue = "N") String bipolarCK
            ,@RequestParam(value="ocdCK", defaultValue = "N") String ocdCK
            ,@RequestParam(value="relationCK", defaultValue = "N") String relationCK
            ,@RequestParam(value="sessionVidCallCK", defaultValue = "N") String sessionVidCallCK
            ,@RequestParam(value="sessionChatCK", defaultValue = "N") String sessionChatCK
            ,@RequestParam(value="sessionInPersonCK", defaultValue = "N") String sessionInPersonCk
            ,@ModelAttribute UserDTO user, @ModelAttribute TherapistDTO therapist, @ModelAttribute DataFileDTO dataFile) throws UserRegistException, ModifyInfoException {


        System.out.println("[UserController] therapistRegist 들어옴");

        user.setUserId(username);
        user.setPwd(passwordEncoder.encode(password));
        user.setEmail(emailId + '@' + emailDomain);
        String registDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setRegistDate(registDate);
        user.setAuthorityCode(2);

        therapist.setUserId(username);
        /*checkBox .charAT() logic*/
        therapist.setDepressionCK(depressionCK.charAt(0));
        therapist.setAnxietyCK(anxietyCK.charAt(0));
        therapist.setBipolarCK(bipolarCK.charAt(0));
        therapist.setOcdCK(ocdCK.charAt(0));
        therapist.setRelationCK(relationCK.charAt(0));
        /*=============================*/
        therapist.setSessionVidCallCK(sessionVidCallCK.charAt(0));
        therapist.setSessionChatCK(sessionChatCK.charAt(0));
        therapist.setSessionInPersonCK(sessionInPersonCk.charAt(0));

        System.out.println("[UserController] UserRegist : " + user);
        System.out.println("[UserController] therapistRegist : " + therapist);


        userService.registTherapist(user, therapist, dataFile, therapistFiles);


        return "user/therapistRegistSuccess";
        }



    @GetMapping("/therapistRegistSuccess")
    public String therapistRegistSuccess() { return "user/therapistRegistSuccess"; }

    @GetMapping("/loginfail")
    public ModelAndView loginFail(@RequestParam String errorMessage, ModelAndView mv) {
        mv.addObject("message", errorMessage);
        mv.setViewName("user/loginfail");

        return mv;
    }

    @GetMapping("/bookingStat")
    public String bookingDetails(@RequestParam("userId")String userId, Model model){

            List<BookingDTO> data = userService.bookingStatus(userId);

            log.info(data.toString());

            model.addAttribute("data", data);

            return "index";
    }
    @GetMapping("/findId")
    public String findId() {return "user/findId"; }


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