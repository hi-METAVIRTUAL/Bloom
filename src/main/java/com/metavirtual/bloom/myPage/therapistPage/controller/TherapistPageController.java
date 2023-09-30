package com.metavirtual.bloom.myPage.therapistPage.controller;

import com.metavirtual.bloom.booking.model.dto.BookingDTO;
import com.metavirtual.bloom.common.exception.myPage.ModifyInfoException;
import com.metavirtual.bloom.common.paging.Paging;
import com.metavirtual.bloom.common.paging.SelectCriteria;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.BookDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ProfileFileDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.dto.ReservationDTO;
import com.metavirtual.bloom.myPage.therapistPage.model.service.TherapistPageServiceImpl;
import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import com.metavirtual.bloom.user.model.dto.UserImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
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
    public String profile(Model model, Authentication authentication){

        if (authentication != null && authentication.isAuthenticated()){
//            UserImpl user = (UserImpl) authentication.getPrincipal();
            UserDTO user = therapistPageService.userInfo(authentication.getName());
            model.addAttribute("user", user);
            TherapistDTO therapist = therapistPageService.therapistInfo(authentication.getName());
            model.addAttribute("therapist", therapist);
            ProfileFileDTO profile = therapistPageService.profileInfo(authentication.getName());
            model.addAttribute("profile", profile);
        }

        return "mypage/therapist/therapistInfo";
    }

    @PostMapping("/imgUpload")
    public String uploadProfileImg(HttpServletRequest request, @RequestParam("therapistImage") MultipartFile profileImage
                                    , RedirectAttributes rttr, Authentication authentication) throws ModifyInfoException{

        log.info("");
        log.info("[TherapistPageController] ========");

        String rootLocation = ROOT_LOCATION + IMAGE_DIR;

        String fileUploadDirectory = rootLocation + "/upload/profileImg";

        File directory = new File(fileUploadDirectory);

        log.info("[TherapistController] fileUploadDirectory : "+ directory);

        if(!directory.exists()){
            directory.mkdirs();
        }

        String fileOriginName = profileImage.getOriginalFilename();
        String ext = fileOriginName.substring(fileOriginName.lastIndexOf("."));
        String fileChangedName = UUID.randomUUID().toString().replaceAll("-", "") + ext;

        ProfileFileDTO uploadInfo = new ProfileFileDTO();
        uploadInfo.setFileChangedName(fileChangedName);
        uploadInfo.setUserId(authentication.getName());
        uploadInfo.setFileSize((int) profileImage.getSize());
        uploadInfo.setFilePath(fileUploadDirectory);
        uploadInfo.setFileOriginName(fileOriginName);

        therapistPageService.uploadProfileImg(uploadInfo);

        try {
            profileImage.transferTo(new File(fileUploadDirectory + "/" + fileChangedName));
            rttr.addFlashAttribute("prfSuccessMessage", "사진이 정상적으로 등록되었습니다!");
        } catch (IOException e) {
            e.printStackTrace();
            rttr.addFlashAttribute("prfErrorMessage", "사진 등록 실패. 문제가 계속될 경우 고객센터로 문의 바랍니다.");
        }



        log.info("[TherapistController] ========");

        return "redirect:/therapist/therapistInfo";
    }

    @GetMapping("/modifyTherapistInfo")
    public String therapistInfo(Model model, Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()){
            UserDTO user = therapistPageService.userInfo(authentication.getName());
            model.addAttribute("user", user);
        }
        return "mypage/therapist/modifyTherapistInfo";
    }

    @PostMapping("/modifyTherapistInfo")
    public String changeTherapistInfo(@ModelAttribute UserDTO user, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) throws ModifyInfoException{
        log.info("");
        log.info("");
        log.info("[TherapistController] modifyTherapistInfo ========");

        user.setPwd(passwordEncoder.encode(user.getPwd()));
        user.setEmail(request.getParameter("emailId")+"@"+request.getParameter("emailDomain"));
        user.setPhone(request.getParameter("phone"));

        log.info("[TherapistController] modifyTherapistInfo request User : "+user);

         try {
            therapistPageService.modifyTherapistInfo(user);
            rttr.addFlashAttribute("infoSuccessMessage", "개인 정보 수정에 성공하셨습니다!");
        } catch(ModifyInfoException e) {
             rttr.addFlashAttribute("infoErrorMessage", "❌상담사 정보 수정 실패❌");
         }

        return "redirect:/therapist/therapistInfo";
    }

    @RequestMapping("/modifyActivationStatus")
    @ResponseBody
    public String modifyActivationStatus(@RequestBody char status, Authentication authentication) throws ModifyInfoException{
        boolean updateSuccess = false;
        if(status == 'Y'){
            updateSuccess = therapistPageService.modifyActivationStatus('N', authentication.getName());
        } else if(status == 'N') {
            updateSuccess = therapistPageService.modifyActivationStatus('Y', authentication.getName());
        }
        if(updateSuccess){
            return "1";
        } else {
            return "0";
        }
    }

    @GetMapping("/modifyTherapistProfile")
    public String modifyTherapistProfile(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()){
            UserImpl user = (UserImpl) authentication.getPrincipal();
            model.addAttribute("user", user);
            TherapistDTO therapist = therapistPageService.therapistInfo(authentication.getName());
            model.addAttribute("therapist", therapist);
        }
            return "mypage/therapist/modifyTherapistProfile";
    }

    @PostMapping("/modifyTherapistProfile")
    public String changeTherapistProfile(@RequestParam(value="depressionCK", defaultValue = "N") String depressionCK
            , @RequestParam(value="anxietyCK", defaultValue = "N") String anxietyCK , @RequestParam(value="bipolarCK", defaultValue = "N") String bipolarCK
            , @RequestParam(value="ocdCK", defaultValue = "N") String ocdCK , @RequestParam(value="relationCK", defaultValue = "N") String relationCK
            , @RequestParam(value="sessionVidCallCK", defaultValue = "N") String sessionVidCallCK , @RequestParam(value="sessionChatCK", defaultValue = "N") String sessionChatCK
            , @RequestParam(value="sessionInPersonCK", defaultValue = "N") String sessionInPersonCk, @ModelAttribute TherapistDTO therapist, HttpServletRequest request
            , HttpServletResponse response, RedirectAttributes rttr) throws ModifyInfoException{
        log.info("");
        log.info("[TherapistController] modifyTherapistProfile ========");

        therapist.setDepressionCK(depressionCK.charAt(0));
        therapist.setAnxietyCK(anxietyCK.charAt(0));
        therapist.setBipolarCK(bipolarCK.charAt(0));
        therapist.setOcdCK(ocdCK.charAt(0));
        therapist.setRelationCK(relationCK.charAt(0));
        therapist.setSessionVidCallCK(sessionVidCallCK.charAt(0));
        therapist.setSessionChatCK(sessionChatCK.charAt(0));
        therapist.setSessionInPersonCK(sessionInPersonCk.charAt(0));

        log.info("[TherapistController] modifyTherapistProfile request Therapist : "+therapist);

        therapistPageService.modifyTherapistProfile(therapist);

        try {
            therapistPageService.modifyTherapistProfile(therapist);
            rttr.addFlashAttribute("profileSuccessMessage", "프로필 정보 수정에 성공하셨습니다!"); // 성공 메시지 추가
        } catch (ModifyInfoException e) {
            rttr.addFlashAttribute("profileErrorMessage", "❌상담사 프로필 수정 실패❌");
        }

        return "redirect:/therapist/therapistInfo";
    }

    @GetMapping("/reservManage")
    public ModelAndView reservManage(HttpServletRequest request
                                , @RequestParam(value = "currentPage", defaultValue = "1") int pageNo, ModelAndView mv){

        log.info("");
        log.info("");
        log.info("[TherapistController] ========");

        int totalBoardCount = therapistPageService.selectReservationCount();
        log.info("[TherapistController] totalReservationCount : "+totalBoardCount);

        int limitPerPage = 5;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = Paging.getSelectCriteria(pageNo, totalBoardCount, limitPerPage, buttonAmount);

        log.info("[TherapistController] selectCriteria : "+selectCriteria);

        List<ReservationDTO> reservationList = therapistPageService.selectReservationList(selectCriteria);

        log.info("[TherapistController] reservationList : "+reservationList);

        mv.addObject("reservationList", reservationList);
        mv.addObject("selectCriteria", selectCriteria);
        log.info("[TherapistController] SelectCriteria : "+selectCriteria);
        mv.setViewName("/mypage/therapist/reservManage");

        log.info("[TherapistController] ========");
        return mv;
    }

    @PostMapping("/acceptReservation")
    public String confirmReservation(HttpServletRequest request, HttpServletResponse response, BookingDTO bookingDTO) throws ModifyInfoException{
        int bookingCode = Integer.parseInt(request.getParameter("bookingCode"));
        bookingDTO.setBookingCode(bookingCode);

        therapistPageService.confirmReservation(bookingCode);

        return "redirect:/therapist/reservManage";
    }

    @PostMapping("/rejectReservation")
    public String declineReservation(HttpServletRequest request, HttpServletResponse response, BookingDTO bookingDTO) throws ModifyInfoException{
        int bookingCode = Integer.parseInt(request.getParameter("bookingCode"));
        bookingDTO.setBookingCode(bookingCode);

        therapistPageService.confirmReservation(bookingCode);

        return "redirect:/therapist/reservManage";
    }

    @GetMapping("/reservation")
    public List<BookDTO> bookingList() throws Exception {
        List<BookDTO> bookingList = therapistPageService.bookingList();
        return bookingList;
    }

    @GetMapping("/reservPopup")
    public String reservPopup() {
        return "mypage/therapist/reservPopup";
    }
}

//push용 주석
