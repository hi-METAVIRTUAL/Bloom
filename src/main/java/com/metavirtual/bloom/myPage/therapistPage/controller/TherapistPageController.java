package com.metavirtual.bloom.myPage.therapistPage.controller;

import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ProfileFileDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.service.TherapistPageServiceImpl;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/therapist")
public class TherapistPageController {

    @Value("${image.image-dir}")
    private String IMAGE_DIR;

    @Value("${spring.servlet.multipart.location}")
    private String ROOT_LOCATION;

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

    @PostMapping("/imgUpload")
    public String uploadProfileImg(HttpServletRequest request, @RequestParam("therapistImage") MultipartFile therapistImage,
                                   RedirectAttributes rttr, String singleFileDescription, Model model,
                                   @ModelAttribute ProfileFileDTO profileFileDTO) throws ModifyInfoException{

        log.info("");
        log.info("");
        log.info("[TherapistPageController] ========");

        String rootLocation = ROOT_LOCATION + IMAGE_DIR;

        String fileUploadDirectory = rootLocation + "/upload/profileImg";

        File directory = new File(fileUploadDirectory);

        log.info("[TherapistController] fileUploadDirectory : "+ directory);

        if(!directory.exists()){
            log.info("[TherapistController] 폴더 생성 : " + directory.mkdirs());
        }

        String fileOriginName = therapistImage.getOriginalFilename();
        String ext = fileOriginName.substring(fileOriginName.lastIndexOf("."));
        String fileChangedName = UUID.randomUUID().toString().replaceAll("-", "") + ext;

        therapistPageService.uploadProfileImg(profileFileDTO);

        try {
            therapistImage.transferTo(new File(fileUploadDirectory + "/" + fileChangedName));
            rttr.addFlashAttribute("message", "파일 업로드 성공!");
        } catch (IOException e) {
            e.printStackTrace();
            rttr.addFlashAttribute("message", "파일 업로드 실패.");
        }



        log.info("[TherapistController] ========");

        return "redirect:/therapist/therapistInfo";
    }

    @GetMapping("/modifyTherapistInfo")
    public String modifyTherapistInfo(){
        return "mypage/therapist/modifyTherapistInfo";
    }

    @PostMapping("/modifyTherapistInfo")
    public String changeTherapistInfo(@ModelAttribute UserDTO user, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) throws ModifyInfoException{
        log.info("");
        log.info("");
        log.info("[TherapistController] modifyTherapistInfo ========");

        user.setPwd(passwordEncoder.encode(user.getPwd()));
        user.setEmail(request.getParameter("emailId")+"@"+request.getParameter("emailDomain"));
        user.setPhone(request.getParameter("phonef")+"-"+request.getParameter("phonem")+"-"+request.getParameter("phonel"));

        log.info("[TherapistController] modifyTherapistInfo request User : "+user);

        therapistPageService.modifyTherapistInfo(user);

        rttr.addFlashAttribute("message", "개인 정보 수정에 성공하셨습니다!");

        return "redirect:/mypage/therapist/therapistInfo";
    }

    @PostMapping(value = "/modifyActivationStatus")
    public String modifyActivationStatus(HttpServletRequest request, @ModelAttribute TherapistDTO therapist, RedirectAttributes rttr) throws ModifyInfoException{
        log.info("");
        log.info("");
        log.info("[TherapistController] modifyActivationStatus ========");

        if(therapist.getActivationStatus() == 'Y'){
            therapist.setActivationStatus('N');
        } else {
            therapist.setActivationStatus('Y');
        }

        log.info("[TherapistController] modifyActivationStatus ========");

        therapistPageService.modifyActivationStatus(therapist.getActivationStatus());

        rttr.addFlashAttribute("message", "상담활동 활성화 여부 변경 성공!");

        return "redirect:/mypage/therapist/therapistInfo";
    }

    @GetMapping("/modifyTherapistProfile")
    public String profileSetting(){
        return "mypage/therapist/modifyTherapistProfile";
    }

    @PostMapping("/modifyTherapistProfile")
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
        therapist.setOcdCK(therapist.getOcdCK());
        therapist.setRelationCK(therapist.getRelationCK());
        therapist.setSessionVidCallCK(therapist.getSessionVidCallCK());
        therapist.setSessionChatCK(therapist.getSessionChatCK());
        therapist.setSessionInPersonCK(therapist.getSessionInPersonCK());

        log.info("[TherapistController] modifyTherpistProfile request Therapist : "+therapist);

        therapistPageService.modifyTherapistProfile(therapist);

        rttr.addFlashAttribute("message", "프로필 정보 수정에 성공하셨습니다!");

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
