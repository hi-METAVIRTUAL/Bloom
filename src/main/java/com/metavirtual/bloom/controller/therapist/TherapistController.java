package com.metavirtual.bloom.controller.therapist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/therapist")
public class TherapistController {

    @GetMapping("/infoSetting")
    public String infoSetting() {
        return "mypage/therapist/infoSetting";
    }

    @GetMapping("/profile")
    public String profile() {
        return "mypage/therapist/profile";
    }

    @GetMapping("/profileSetting")
    public String profileSetting() {
        return "mypage/therapist/profileSetting";
    }

    @GetMapping("/reservManage")
    public String reservManage() {
        return "mypage/therapist/reservManage";
    }

    @GetMapping("/reservPopup")
    public String reservPopup() {
        return "mypage/therapist/reservPopup";
    }
}
