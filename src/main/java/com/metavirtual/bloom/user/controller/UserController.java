package com.metavirtual.bloom.user.controller;

//import com.metavirtual.bloom.common.exception.myPage.UserRegistException;
import com.metavirtual.bloom.common.exception.member.UserRegistException;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
/*import com.metavirtual.bloom.user.model.service.UserServiceImpl;*/
import com.metavirtual.bloom.user.model.service.UserServiceImpl;

        import org.springframework.beans.factory.annotation.Autowired;
        /*import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        user.setPwd(passwordEncoder.encode(password));
        user.setEmail(emailId + '@' + emailDomain);
        String registDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setRegistDate(registDate);

        member.setUserId(username);

        System.out.println("유저 가져온 결과 = " + user.getUserId() + " " + user.getPwd() + " " + user.getEmail() + " " + user.getRegistDate() + " " + user.getAuthority_code());
        System.out.println("총 결과 = " + user.getUserId() + " " + user.getPwd() + " " + user.getName() + " "
                + user.getGender() + " " + user.getEmail() + " " + user.getPhone() + " " + user.getRegistDate() + " " + user.getAuthority_code());

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

    @PostMapping("/memberRegistSuccess")
    public String regularRegistSuccess() {
        return "user/memberRegistSuccess"; }

    @GetMapping("/therapistRegistPI")
    public String registTherapist(){
        return "user/therapistRegistPI";
    }

    @PostMapping("/therapistRegistPI")
    public String therapistRegist(@RequestParam String username, @RequestParam String password, @RequestParam String emailId, @RequestParam String emailDomain,
                                  @ModelAttribute UserDTO user) throws UserRegistException {

        System.out.println("[UserController] 들어옴");
        user.setUserId(username);
        user.setPwd(passwordEncoder.encode(password));
        user.setEmail(emailId + '@' + emailDomain);
        String registDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setRegistDate(registDate);

        System.out.println(user);
        userService.registTherapistPI(user);

        return "user/therapistRegist2";
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