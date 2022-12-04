package com.example.studyapp.Controllers;

import com.example.studyapp.emailSender.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.internet.MimeMessage;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/email")
    public String email(){
        return "sendEmail";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String text
    ){
        emailService.sendSimpleMessage(to, subject, text);
        return "sendEmail";
    }
}
