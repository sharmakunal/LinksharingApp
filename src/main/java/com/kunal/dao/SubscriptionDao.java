package com.kunal.dao;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;

import java.util.List;

public interface SubscriptionDao {
    public Boolean addSubscriber(User user, Topic topic);
    public List<Topic> getTopicsSubscribeByUser(User user);
}
