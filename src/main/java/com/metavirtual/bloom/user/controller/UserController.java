package com.metavirtual.bloom.user.controller;

//import com.metavirtual.bloom.common.exception.myPage.UserRegistException;
import com.metavirtual.bloom.common.exception.member.UserRegistException;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.DataFileDTO;
import com.metavirtual.bloom.user.model.dto.MemberDTO;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
/*import com.metavirtual.bloom.user.model.service.UserServiceImpl;*/
import com.metavirtual.bloom.user.model.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
        /*import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserServiceImpl userService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${image.image-dir}")
    private String IMAGE_DIR;

    @Value("${spring.servlet.multipart.location}")
    private String ROOT_LOCATION;
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
                               @ModelAttribute UserDTO user, @ModelAttribute MemberDTO member) throws UserRegistException {


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


        userService.registUser(user, member);

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

    @GetMapping("/therapistRegist")
    public String registTherapist(){

        return "/user/therapistRegist";
    }

    @PostMapping("/therapistRegist")
    public String therapistRegist(@RequestParam String username, @RequestParam String password, @RequestParam String emailId
                , @RequestParam String emailDomain, HttpServletRequest request, @RequestParam("therapistFile") MultipartFile therapistFile
                ,@RequestParam(value="depressionCK", defaultValue = "N") String depressionCk
                ,@RequestParam(value="anxietyCK", defaultValue = "N") String anxietyCK
                ,@RequestParam(value="bipolarCK", defaultValue = "N") String bipolarCK
                ,@RequestParam(value="ocdCK", defaultValue = "N") String ocdCK
                ,@RequestParam(value="relationCK", defaultValue = "N") String relatonCK
                ,@RequestParam(value="sessionVidCallCK", defaultValue = "N") String sessionVidCallCK
                ,@RequestParam(value="sessionChatCK", defaultValue = "N") String sessionChatCK
                ,@RequestParam(value="sessionInPersonCK", defaultValue = "N") String sessionInPersonCk
                ,RedirectAttributes rttr, String singleFileDescription, Model model
                ,@ModelAttribute UserDTO user, @ModelAttribute TherapistDTO therapist, @ModelAttribute DataFileDTO dataFile) throws UserRegistException, ModifyInfoException {


        System.out.println("[UserController] therapistRegist 들어옴");
        user.setUserId(username);
        user.setPwd(passwordEncoder.encode(password));
        user.setEmail(emailId + '@' + emailDomain);
        String registDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setRegistDate(registDate);


        therapist.setUserId(username);
        /*checkBox .charAT() logic*/
        therapist.setDepressionCK(depressionCk.charAt(0));
        therapist.setAnxietyCK(anxietyCK.charAt(0));
        therapist.setBipolarCK(bipolarCK.charAt(0));
        therapist.setOcdCK(ocdCK.charAt(0));
        therapist.setRelationCK(relatonCK.charAt(0));
        /*=============================*/
        therapist.setSessionVidCallCK(sessionVidCallCK.charAt(0));
        therapist.setSessionChatCK(sessionChatCK.charAt(0));
        therapist.setSessionInPersonCK(sessionInPersonCk.charAt(0));


        System.out.println("[UserController] therapistRegist : " + user);
        System.out.println("[UserController] therapistRegist : " + therapist);


        String rootLocation = ROOT_LOCATION + IMAGE_DIR;

        String fileUploadDirectory = rootLocation + "/upload/therapistDataFile";

        File directory = new File(fileUploadDirectory);

        log.info("[TherapistController] fileUploadDirectory : "+ directory);

        if(!directory.exists()){
            log.info("[TherapistController] 폴더 생성 : " + directory.mkdirs());
        }

        String fileOriginName = therapistFile.getOriginalFilename();
        String ext = fileOriginName.substring(fileOriginName.lastIndexOf("."));
        String fileChangedName = UUID.randomUUID().toString().replaceAll("-", "") + ext;

        userService.registTherapist(user, therapist, dataFile);

        try {
            therapistFile.transferTo(new File(fileUploadDirectory + "/" + fileChangedName));
            rttr.addFlashAttribute("message", "파일 업로드 성공!");
        } catch (IOException e) {
            e.printStackTrace();
            rttr.addFlashAttribute("message", "파일 업로드 실패.");
        }




        return "user/therapistRegistSuccess";
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