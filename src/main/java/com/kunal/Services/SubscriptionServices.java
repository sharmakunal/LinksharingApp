package com.kunal.Services;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SubscriptionServices {
    public Boolean addSubscriber(User user, Topic topic);
    public List<Topic> getTopicsSubscribeByUser(User user);
}
