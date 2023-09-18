package com.metavirtual.bloom.myPage.therapistPage.controller;

import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.myPage.therapistPage.model.service.TherapistPageServiceImpl;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/therapist")
public class TherapistPageController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final PasswordEncoder passwordEncoder;
    private final TherapistPageServiceImpl therapistPageService;
    public TherapistPageController(PasswordEncoder passwordEncoder, TherapistPageServiceImpl therapistPageService){
        this.passwordEncoder = passwordEncoder;
        this.therapistPageService = therapistPageService;
    }

    @GetMapping("/therapistInfo")
    public String profile(){
        return "mypage/therapist/therapistInfo";
    }

    @GetMapping("/modifyTherapistInfo")
    public String infoSetting(){
        return "mypage/therapist/modifyTherapistInfo";
    }

    @PostMapping("/modifyTherapistInfo")
    public String changeTherapistInfo(@ModelAttribute UserDTO user, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) throws ModifyInfoException{
        log.info("");
        log.info("");
        log.info("[TherapistController] modifyTherapistInfo ========");

        user.setPwd(passwordEncoder.encode(user.getPwd()));
        user.setEmail(user.getEmail());
        user.setPhone(user.getPhone());

        log.info("[TherapistController] modifyTherapistInfo request User : "+user);

        therapistPageService.modifyTherapistInfo(user);

        return "redirect:/mypage/therapist/therapistInfo";
    }

    @GetMapping("/modifyTherapistProfile")
    public String profileSetting(){
        return "mypage/therapist/modifyTherapistProfile";
    }

    public String changeTherapistProfile(@ModelAttribute TherapistDTO therapist, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) throws ModifyInfoException{
        log.info("");
        log.info("");
        log.info("[TherapistController] modifyTherapistProfile ========");

        therapist.setTherapistQ1(therapist.getTherapistQ1());
        therapist.setTherapistQ2(therapist.getTherapistQ2());
        therapist.setTherapistQ3(therapist.getTherapistQ3());
        therapist.setOrganization(therapist.getOrganization());
        therapist.setDepressionCK(therapist.getDepressionCK());
        therapist.setAnxietyCK(therapist.getAnxietyCK());
        therapist.setBipolarCK(therapist.getBipolarCK());
        therapist.setOcd_CK(therapist.getOcd_CK());
        therapist.setRelationCK(therapist.getRelationCK());
        therapist.setSessionVidCallCK(therapist.getSessionVidCallCK());
        therapist.setSessionChatCK(therapist.getSessionChatCK());
        therapist.setSessionInPersonCK(therapist.getSessionInPersonCK());

        log.info("[TherapistController] modifyTherpistProfile request Therapist : "+therapist);

        therapistPageService.modifyTherapistProfile(therapist);

        return "redirect:/mypage/therapist/therapistInfo";
    }

    @PostMapping
    public String modifyActivationStatus(HttpServletRequest request) throws ModifyInfoException{



        return "redirect:/mypage/therapist/therapistInfo";
    }

    @GetMapping("/reservManage")
    public String reservManage(){
        return "mypage/therapist/reservManage";
    }

    @GetMapping("/reservPopup")
    public String reservPopup() {
        return "mypage/therapist/reservPopup";
    }
}

//push용 주석
