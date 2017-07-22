package com.kunal.dao;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import org.springframework.stereotype.Repository;

public interface TopicDao {
    public Boolean addTopicByUser(String name,String visibility,User user);
    public Boolean validationOfTopicName(String username);
    public Topic getTopic(int topicId);
}
