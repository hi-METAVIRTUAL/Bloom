package com.metavirtual.bloom.mailVerification;

import com.metavirtual.bloom.user.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
public class MailController {

    Logger log;

    private final MailService mailService;

    @ResponseBody
    @PostMapping("/mail")
    public String MailSend(String mail){

        int number = mailService.sendMail(mail);

        String num = "" + number;

        return num;
    }



    @PostMapping("/mail/findId")
    public String sendId(@RequestParam("name") String name, @RequestParam("email") String email
            , @ModelAttribute UserDTO userDTO) {

        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);

        String findDetails = mailService.findDetails(name, email);

        return "/user/verificationIdSent";
    }

}