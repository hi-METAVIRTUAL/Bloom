package com.metavirtual.bloom.mailVerification;

import com.metavirtual.bloom.user.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @ResponseBody
    @PostMapping("/mail")
    public String MailSend(String mail){

        int number = mailService.sendMail(mail);

        String num = "" + number;

        return num;
    }


/*    @ResponseBody
    @PostMapping("/mail/findId")
    public String sendId(@RequestParam("nickName") String nickName, @RequestParam("email") String email, @ModelAttribute UserDTO userDTO) {

        String findDetails = mailService.findDetails(nickName, email);

        return null;
    }*/
}