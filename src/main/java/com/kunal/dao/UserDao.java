package com.kunal.dao;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;

import java.util.List;

public interface UserDao {
    public Boolean registerUser(User user);
    public User loginUser(String username,String password);
    public Boolean validationOfUserbyEmail(String email);
    public Boolean validationOfUserbyUsername(String username);
    public User getDetailofUser(String username);
    //public Boolean addTopics(List<Topic> topic);
    public User getUserByEmail(String email) ;
    public User getUserByUsername(String userName);
    public void updatePassword(User user);

}
