package com.kunal.controller;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import com.kunal.Services.ResourcesServices;
import com.kunal.Services.TopicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class ResourcesController {

    @Autowired
    TopicServices topicServices;

    @Autowired
    ResourcesServices resourcesServices;

    @RequestMapping(value = "/addLinkResource")
    public @ResponseBody
    String addLinkResource(HttpSession session, @RequestParam("url") String url,
                           @RequestParam("description") String description, @RequestParam("topicsAdd") String topicsAdd){

        if(url !=" " || description != " " || topicsAdd != " "){
            User user = (User) session.getAttribute("user");
            Topic topic=topicServices.getTopic(Integer.parseInt(topicsAdd));
            if(topic!=null) {
                resourcesServices.addLinkResource(description, user, topic, url);
                System.out.println("url : " + url + "desscription  " + description + " topic : " + topicsAdd);
                return "true";
            }
            return "false";
        }else {
            return "false";
        }
    }
    @RequestMapping(value = "/addDocumentResource")
    public @ResponseBody
    ModelAndView addDocumentResource(HttpSession session,
                                     @RequestParam("description") String description, @RequestParam("documentTopicAdd") String documentTopicAdd,
                                     @RequestParam("file") MultipartFile file) throws Exception {
        try {
            if(!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                File file2 = new File("E:\\files\\" + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(file2)
                );
                stream.write(bytes);
                stream.close();
                System.out.println(file2);
                User user = (User) session.getAttribute("user");
                Topic topic=topicServices.getTopic(Integer.parseInt(documentTopicAdd));
                if(topic!=null && user!=null) {
                    resourcesServices.addLinkResource(description, user, topic,"E:\\files\\"+file.getOriginalFilename());
                    System.out.println("desscription  " + description + " topic : " + documentTopicAdd);
                    return new ModelAndView("dashboard");
                   }else{
                    ModelAndView modelAndView = new ModelAndView("dasboard");
                    modelAndView.addObject("fileNotUpload","Resource Not Uploaded Due Some Wrong Input");
                    return modelAndView;
                }
            }
        }  catch (Exception exception) {
            exception.printStackTrace();
            ModelAndView modelAndView = new ModelAndView("dasboard");
            modelAndView.addObject("fileNotUpload","Resource Not Uploaded Due Some Error ");
            return modelAndView;
        }
        return new ModelAndView("dashboard");
     }
}

