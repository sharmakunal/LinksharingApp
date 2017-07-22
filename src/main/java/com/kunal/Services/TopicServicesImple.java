package com.kunal.Services;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import com.kunal.dao.TopicDao;
import com.kunal.dao.TopicDaoImple;
import org.springframework.stereotype.Service;

@Service
public class TopicServicesImple implements TopicServices {

    private TopicDao topicDao = new TopicDaoImple();;

    @Override
    public Boolean addTopicByUser(String name,String visibility, User user) {
        this.topicDao = new TopicDaoImple();
       if(topicDao.addTopicByUser(name,visibility,user)){
           return true;
       }else{
           return false;
       }
    }

    @Override
    public Boolean validationOfTopicName(String name) {
       return topicDao.validationOfTopicName(name);
    }

    @Override
    public Topic getTopic(int topicId) {
        return topicDao.getTopic(topicId);
    }
}
