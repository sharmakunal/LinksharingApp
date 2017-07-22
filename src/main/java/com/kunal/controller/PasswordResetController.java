package com.kunal.controller;

import com.kunal.Entity.PasswordChangeRequest;
import com.kunal.Entity.User;
import com.kunal.Services.MailNotification;
import com.kunal.Services.PasswordChangeRequestServicesImpl;
import com.kunal.Services.UserServicesImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Controller
public class PasswordResetController {
    //    -----------------------password reset----------------------------
    @Autowired
    MailNotification mailNotification;
    @Autowired
    PasswordChangeRequestServicesImpl passwordChangeRequestServices;
    @Autowired
    UserServicesImple userServices;

    @RequestMapping(value="/email-notification",method= RequestMethod.POST)
    public ModelAndView reset(HttpServletRequest request, @RequestParam String email){

        ModelAndView modelAndView=new ModelAndView("password-reset");

        try{
            User user=(User)userServices.getUserByEmail(email);
            if (user!=null)
            {
                String otp=mailNotification.notifyEmail(email);
                PasswordChangeRequest passwordChangeRequest=new PasswordChangeRequest();
                passwordChangeRequest.setTime(Instant.now());
                passwordChangeRequest.setEmail(email);
                passwordChangeRequest.setId(otp);
                passwordChangeRequestServices.save(passwordChangeRequest);

                modelAndView.addObject("msg","Please check your mail and click the link to update password.");
            }else {
                modelAndView.addObject("msg","This email address does not exists.");
            }
        }
        catch (Exception e){
            modelAndView.addObject("msg","This email address does not exists.");
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping(value="/reset")
    public ModelAndView reset(){
        return new ModelAndView("password-reset");
    }

    @RequestMapping(value = "password_update",method= RequestMethod.POST)
    public ModelAndView password_update(@RequestParam("email") String email,@RequestParam("pswd") String password,@RequestParam("cpswd") String cpassword){
//        --------password update----
        User user=(User)userServices.getUserByEmail(email);
        if (user!=null ) {
            if (password.equals(cpassword)){
                user.setPassword(password);
                user.setLastUpdated(new Date());
                userServices.updatePassword(user);
                return new ModelAndView("index","LoginMessage","Password updated.");
                } else{
                return new ModelAndView("update-password","msg","Passwords do not match!");
            }
        }
        return new ModelAndView("index","LoginMessage","Password cannot be updated.");

    }



    @RequestMapping(value="/linkToChangePassword/{email}/{otp}")
    public ModelAndView accessUpdate(@PathVariable("otp") String token, @PathVariable("email") String email ){
        try{
            System.out.println(token+"-------------"+email);

            PasswordChangeRequest passwordChangeRequest=(PasswordChangeRequest)passwordChangeRequestServices.get(email,token);

            System.out.println(passwordChangeRequest);

            Instant start=passwordChangeRequest.getTime();
            Instant end=Instant.now();

            Duration dur = Duration.between(start,end);
            long mins = dur.toMinutes();


            if (mins<5)
            {
                ModelAndView modelAndView=new ModelAndView("update-password");
                modelAndView.addObject("email",email);
                passwordChangeRequestServices.delete(passwordChangeRequest);
                return modelAndView;
            }else {
                return new ModelAndView("password-reset","msg","Link expired.");
            }}catch (Exception e){
            e.printStackTrace();
        }
        return new ModelAndView("password-reset","msg","Link expired.");
    }

}
