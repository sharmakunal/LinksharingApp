package com.kunal.dao;

import com.kunal.Entity.Seriousness;
import com.kunal.Entity.Subscription;
import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import com.kunal.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;
@Repository
public class SuscriptionDaoImple implements SubscriptionDao{
    @Override
    public Boolean addSubscriber(User user, Topic topic) {
        try {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Subscription subscription = new Subscription();
        subscription.setSeriousness(Seriousness.VerySerious);
        subscription.setDateCreated(new Date());
        subscription.setTopic(topic);
        subscription.setUser(user);
        session.save(subscription);
        session.getTransaction().commit();
        return true;
    }catch (Exception e){
        e.printStackTrace();
        return false;
       }
    }

    @Override
    public List<Topic> getTopicsSubscribeByUser(User user) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "select topic FROM Subscription S WHERE S.user= :user";
        Query query=session.createQuery(sql);
        query.setParameter("user",user);
        List<Topic> list=query.getResultList();
        if(list.isEmpty()){
            return null;
        }else{
            return list;
        }
    }
}
