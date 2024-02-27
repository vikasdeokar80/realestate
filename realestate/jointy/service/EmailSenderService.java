package com.sajal.addressbookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderService {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sajju18coc@gmail.com");
        message.setTo("sajalmajumder18@gmail.com");
        message.setSubject("JWS demo test ");
        message.setText("Hi Sajal,");
        message.setText("Your order has been confirmed.");
        message.setText("This will be shipped soon");
        message.setText("Thank you for shopping with Amazon");
        mailSender.send(message);
        System.out.println("Mail sent successfully to the user.....");
    }
}
