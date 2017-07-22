package com.kunal.controller;
import com.kunal.Entity.LinkResources;
import com.kunal.Entity.User;
import com.kunal.Services.SubscriptionServices;
import com.kunal.Services.UserServices;
import com.kunal.Services.UserServicesImple;
import com.kunal.dao.SubscriptionDao;
import com.kunal.dao.SuscriptionDaoImple;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    UserServices userServices;


    @RequestMapping("/")
    ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/dashboard")
    ModelAndView dashboard(HttpServletRequest request,HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("index");
        }
        else
            return new ModelAndView("dashboard");
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView register(HttpServletRequest request,@ModelAttribute("User") User user,@RequestParam("file") MultipartFile file) throws Exception {
        byte[] photo=null;
        System.out.println(user.toString());
             if (!file.isEmpty()) {
                 photo = file.getBytes();
                 user.setPhoto(photo);
             }else{
            File defaultFile=new File("E:\\images.png");
            FileInputStream fis=new FileInputStream(defaultFile);
            byte b[]=new byte[(int)defaultFile.length()];
            fis.read(b);
            user.setPhoto(b);
            System.out.println("aya to hai isme");
        }
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (userServices.registerUser(user)) {
                request.getSession().setAttribute("user", user);
                return new ModelAndView("dashboard");
            } else {
                ModelAndView modelAndView = new ModelAndView("index");
                modelAndView.addObject("registration", "This username or email is already taken!");
                return modelAndView;
            }
          } else {
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("registration", "Passwords do not match !");
            return modelAndView;
          }
    }

    @ResponseBody
    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,HttpServletResponse response,
                              @RequestParam String username, @RequestParam String password,
                              HttpSession session)  throws IOException{
       User user = userServices.loginUser(username,password);
        if(user!=null){
            request.getSession().setAttribute("user", user);
            ModelAndView modelAndView = new ModelAndView("dashboard");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("LoginMessage", "Wrong credentials !");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/springbean/displayImage", method = RequestMethod.GET)
    public void uploadFileHandler(HttpServletRequest request , HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            IOUtils.copy(new ByteArrayInputStream(user.getPhoto()), response.getOutputStream());
        }
    }

    @RequestMapping(value = "/validateUsername")
    public  @ResponseBody String validateCredentials(@RequestParam("credential")String credential) {
        if (userServices.validationOfUser(credential)) {
            return "true";
        } else {
            return "false";
        }
    }
}
