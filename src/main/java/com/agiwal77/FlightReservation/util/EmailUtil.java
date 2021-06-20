package com.agiwal77.FlightReservation.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender sender;

    public void sendItinerary(String toAddress, String filePath){

        MimeMessage message = sender.createMimeMessage();

        try{
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setTo(toAddress);
            messageHelper.setSubject("Flight booking confirmation");
            messageHelper.setText("Please find the attach PDF of flight booking.");
            messageHelper.addAttachment("booking",new File(filePath));
            sender.send(message);
        }catch (MessagingException e){
            e.printStackTrace();
        }

    }
}
