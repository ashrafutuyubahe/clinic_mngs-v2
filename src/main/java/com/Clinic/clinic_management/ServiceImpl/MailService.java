package com.Clinic.clinic_management.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
 @Value("${spring.mail.password}")
private String from;

@Value("${spring.mail.username}")
private String  fom;


    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
    
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true); 
            helper.setFrom(fom);
    
            mailSender.send(message);
            System.out.println("Mail sent successfully!");
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
    
}
