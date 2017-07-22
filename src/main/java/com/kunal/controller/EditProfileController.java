package com.kunal.controller;

import com.kunal.Entity.User;
import com.kunal.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller
public class EditProfileController {

    @Autowired
    UserServices userServices;

    @RequestMapping("/edit-profile")
    ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("edit-profile");
        return modelAndView;
    }

    @RequestMapping(value = "/password_update_Byuser",method= RequestMethod.POST)
    public ModelAndView password_update(HttpSession session,@RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword){
        User user = (User) session.getAttribute("user");
        if (user!=null ) {
            if (password.equals(confirmPassword)){
                user.setPassword(password);
                user.setLastUpdated(new Date());
                userServices.updatePassword(user);
                return new ModelAndView("edit-profile","SucccessMessage","Password updated.");
            }
            else{
                return new ModelAndView("edit-profile","msg","Passwords do not match!");
            }
        }
        return new ModelAndView("index");
    }


    @RequestMapping(value = "/profile_update_Byuser",method= RequestMethod.POST)
    public ModelAndView profile_update(HttpSession session, @ModelAttribute("User") User  user,
                                       @RequestParam("file") MultipartFile file)throws IOException{
        User user1 = (User) session.getAttribute("user");
        if (user!=null ) {
                user1.setLastUpdated(new Date());
                user1.setFirstName(user.getFirstName());
                user1.setLastName(user.getLastName());
                user1.setUsername(user.getUsername());
                    byte[] photo=null;
                    System.out.println(user.toString());
                    if (!file.isEmpty()) {
                        photo = file.getBytes();
                        user1.setPhoto(photo);
                    }
                userServices.updatePassword(user1);
                return new ModelAndView("edit-profile","SucccessMessage","Profile updated.");
            }
            else{
                return new ModelAndView("edit-profile","msg","Profile  not Updated!");
            }
    }
}
