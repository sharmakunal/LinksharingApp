package com.kunal.Services;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import com.kunal.dao.SubscriptionDao;
import com.kunal.dao.SuscriptionDaoImple;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubscriptionServicesImple implements SubscriptionServices {

    SubscriptionDao subscriptionDao = new SuscriptionDaoImple();
    @Override
    public Boolean addSubscriber(User user, Topic topic) {
        return subscriptionDao.addSubscriber(user,topic);
    }

    @Override
    public List<Topic> getTopicsSubscribeByUser(User user) {
       return subscriptionDao.getTopicsSubscribeByUser(user);
    }

}
