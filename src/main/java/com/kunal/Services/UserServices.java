package com.kunal.Services;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {
    public Boolean registerUser(User user);

    public User loginUser(String username, String password);

    public Boolean validationOfUser(String ifExists);

    public User getDetailofUser(String username);

    public User getUserByEmail(String email) ;
    //public Boolean addTopics(List<Topic> topic);
    public void updatePassword(User user);
}