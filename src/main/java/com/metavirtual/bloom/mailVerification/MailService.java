package com.metavirtual.bloom.mailVerification;

import com.metavirtual.bloom.user.model.dao.UserMapper;
import com.metavirtual.bloom.user.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.util.logging.Logger;

import static javax.swing.text.html.parser.DTDConstants.NUMBERS;

@Service
@RequiredArgsConstructor
public class MailService {

    Logger log;
    private final UserMapper userMapper;
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    private static final String senderEmail = "metavirtual.bloom@gmail.com";
    private static int number;

    private final PasswordEncoder passwordEncoder;

    public static void createNumber() {
        number = (int) (Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값
    }

    public MimeMessage createMail(String mail) {
        createNumber();
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(senderEmail);
            helper.setTo(mail);
            helper.setSubject("이메일 인증");

            // Create a context to hold variables to be replaced in the template
            Context context = new Context();
            context.setVariable("content", String.valueOf(number));

            // Process the HTML template with Thymeleaf
            String htmlContent = templateEngine.process("/user/mail", context);

            // Set the email content as HTML
            helper.setText(htmlContent, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }


    public int sendMail(String mail) {
        MimeMessage message = createMail(mail);
        javaMailSender.send(message);

        return number;
    }

    public MimeMessage createFindId(String email, String name, String findUserId) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(senderEmail);
            helper.setTo(email);
            helper.setSubject("아이디 찾기 이메일 전송");

            // Create a context to hold variables to be replaced in the template
            Context context = new Context();
            context.setVariable("content", String.valueOf(findUserId));
            context.setVariable("name", String.valueOf(name));


            // Process the HTML template with Thymeleaf
            String htmlContent = templateEngine.process("/user/findIdMail", context);

            // Set the email content as HTML
            helper.setText(htmlContent, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }

    public String findDetails(String name, String email) {

        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);


        if (name != null && email != null) {
            String findUserId = userMapper.findDetails(name, email);
            MimeMessage message = createFindId(email, name, findUserId);
            javaMailSender.send(message);
            return findUserId;
        } else {
            return "이름 또는 이메일이 존재하지 않습니다";
        }
    }



}