package com.metavirtual.bloom.mailVerification;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    private static final String senderEmail= "metavirtual.bloom@gmail.com";
    private static int number;

    public static void createNumber(){
        number = (int)(Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값
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


    public int sendMail(String mail){
        MimeMessage message = createMail(mail);
        javaMailSender.send(message);

        return number;
    }
}
