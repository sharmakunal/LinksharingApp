package com.kunal.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by kunal on 21-Jul-17.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;

    @Component
    public class MailNotification {
        @Autowired
        private MailSender mailSender;

        public void setMailSender(MailSender mailSender) {
            this.mailSender = mailSender;
        }

        public void sendMail(String from, String to, String subject, String msg) {

            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(msg);

            mailSender.send(message);
        }

        public String notifyEmail(String email){
            try{
                String sender="coolsparsh234@gmail.com";
                String receiver=email;
                String otp  =  generateOTP();
                String link="http://localhost:8080/linkToChangePassword/"+email+"/"+otp;
                String body="Please follow the below link to change the password.If you have'nt requested for password reset then ignore this mail.Thank you."+"        "+link;
                this.sendMail(sender,receiver,"Link Sharing - password reset",body);
                return otp;
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        public Boolean invitationEmail(String email, String userName, String topicName){
            try{
                String sender="somya777.srivastava@gmail.com";
                String receiver=email;

                String link="http://localhost:8080/";
                String body=userName+" says:"+"Subscribe to "+topicName+" by following this link : "+link;
                this.sendMail(sender,receiver,"Link Sharing - Invitation to subscribe",body);
                return true;
            }
            catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        public String generateOTP()
        {
            int randomPIN = (int)(Math.random()*9000)+1000;
            String otp = String.valueOf(randomPIN);
            return otp;
        }
    }
