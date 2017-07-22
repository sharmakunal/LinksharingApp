package com.kunal.controller;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import com.kunal.Services.*;
import com.kunal.dao.SubscriptionDao;
import com.kunal.dao.SuscriptionDaoImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DashboardController {

     @Autowired
     TopicServicesImple topicServices;

    @Autowired
    UserServices userServices;


    ResourcesServices resourcesServices = new ResourcesServicesImple();

    @RequestMapping(value = "/logout")
    public ModelAndView Logout(HttpSession session){
     session.invalidate();
     return new ModelAndView("redirect:/");
    }

   @RequestMapping(value = "/addTopicbyUser")
    public @ResponseBody String addTopic(@RequestParam("name")String name,@RequestParam("visibility")String visibility,
                                         HttpSession session){
       System.out.println("username" + "  : " + name);
       System.out.println("visibility: " + visibility);
       User user = (User) session.getAttribute("user");
       System.out.println(user.toString());
       if(topicServices.addTopicByUser(name,visibility,user)){
            return "True";
        }else{
            return "false";
        }
   }

    @RequestMapping(value = "/validateTopicName")
    public  @ResponseBody String validateTopicName(@RequestParam("credential")String credential) {
        if (topicServices.validationOfTopicName(credential)) {
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping(value = "/listcheck")
    public @ResponseBody List<Topic> modelAndView(HttpSession session){
        User user = (User) session.getAttribute("user");
        SubscriptionDao subscriptionDao = new SuscriptionDaoImple();
        List<Topic> topics = subscriptionDao.getTopicsSubscribeByUser(user);
        if(topics != null){
            return topics;
        }else {
            return null;
        }
    }

}
