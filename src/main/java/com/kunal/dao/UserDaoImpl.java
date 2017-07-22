package com.kunal.dao;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import com.kunal.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public Boolean registerUser(User user) {
        try {
            Session session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            user.setDateCreated(new Date());
            session.save(user);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }


    @Override
    public User loginUser(String username, String password) {
        User user=null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        user=this.getUserByUsername(username);
        if (user==null){
            user=this.getUserByEmail(username);}
        if (user!=null){
            if(user.getPassword().equals(password))
                return user;
        }
        return null;
    }
    @Override
    public Boolean validationOfUserbyEmail(String email) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
            String sql = "select email FROM User U  WHERE U.email = :email";
            Query query=session.createQuery(sql);
            query.setParameter("email",email);
            List<User> list=query.getResultList();
            if(list.isEmpty()){
                return false;
            }else{
                return true;
            }
    }

    @Override
    public Boolean validationOfUserbyUsername(String username) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
            String sql = "SELECT username FROM User U  WHERE U.username = :username";
            Query query=session.createQuery(sql);
            query.setParameter("username",username);
            List<User> list=query.getResultList();
            if(list.isEmpty()){
                return false;
            }else{
                return true;
            }
    }

    @Override
    public User getDetailofUser(String username) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = " FROM User U  WHERE U.username = :username";
        Query query=session.createQuery(sql);
        query.setParameter("username",username);
        User user=  (User)query.getSingleResult();

        if(user == null){
            return null;
        }else{
            return user;
        }
    }

   /* @Override
    public Boolean addTopics(List<Topic> topic) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            User user = new User();
            user.setTopicList(topic);
            session.save(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String sql = "FROM User U  WHERE U.email = :email";
        Query query = session.createQuery(sql);
        query.setParameter("email", email);

        try {
            Object queryResult = query.getSingleResult();
            if (queryResult != null) {
                user = (User) queryResult;
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    @Override
    public User getUserByUsername(String userName){
        User user = null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); String sql = "FROM User U  WHERE U.username = :username";
        Query query = session.createQuery(sql);
        query.setParameter("username", userName);
        try {
            Object queryResult = query.getSingleResult();
            if (queryResult != null) {
                user = (User) queryResult;
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            return null;
        }
        return user;
    }
    @Override
    public void updatePassword(User user){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }
}
