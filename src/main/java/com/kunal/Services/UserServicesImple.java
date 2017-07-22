package com.kunal.Services;

import com.kunal.Entity.User;
import com.kunal.dao.UserDao;
import com.kunal.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServicesImple implements UserServices {

    @Autowired
    private UserDao userdao;

    @Override
    public Boolean registerUser(User user) {
        userdao = new UserDaoImpl();
        return userdao.registerUser(user);
    }

    @Override
    public User loginUser(String username, String password) {
        userdao = new UserDaoImpl();
        return userdao.loginUser(username, password);
    }

    @Override
    public Boolean validationOfUser(String ifExists) {
        if (ifExists.contains("@")) {
            return userdao.validationOfUserbyEmail(ifExists);
        } else {
            return userdao.validationOfUserbyUsername(ifExists);
        }
    }

    @Override
    public User getDetailofUser(String username) {
        if (userdao.getDetailofUser(username) != null) {
            return userdao.getDetailofUser(username);
        } else {
            return null;
        }
    }
 /*   public Boolean addTopics(List<Topic> topic){
        return userdao.addTopics(topic);
    }*/

    @Override
    public User getUserByEmail(String email){
        return userdao.getUserByEmail(email);
    }

    @Override
    public void updatePassword(User user){
        userdao = new UserDaoImpl();
        userdao.updatePassword(user);
    }

}
