package com.metavirtual.bloom.myPage.therapistPage.controller;

import com.metavirtual.bloom.user.model.dto.TherapistDTO;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TMyPageController {

    @GetMapping("/therapistInfo")
    public String therapistInfo(Model model, Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()){
            UserDTO user = (UserDTO) authentication.getPrincipal();
            model.addAttribute("user", user);

            TherapistDTO therapist = (TherapistDTO) authentication.getPrincipal();
            model.addAttribute("therapist", therapist);
        }
        return "therapistInfo";
    }

    @GetMapping("/modifyTherapistInfo")
    public String modifyTherapistInfo(Model model, Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()){
            UserDTO user = (UserDTO) authentication.getPrincipal();
            model.addAttribute("user", user);
        }
        return "modifyTherapistInfo";
    }
}
