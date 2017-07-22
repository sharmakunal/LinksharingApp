package com.kunal.Services;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface TopicServices {
    public Boolean addTopicByUser(String name,String visibility,User user);
    public Boolean validationOfTopicName(String name);
    public Topic getTopic(int topicId);
}
