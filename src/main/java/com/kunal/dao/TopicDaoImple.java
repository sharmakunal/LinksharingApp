package com.kunal.dao;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import com.kunal.Entity.Visibility;
import com.kunal.Services.SubscriptionServices;
import com.kunal.Services.SubscriptionServicesImple;
import com.kunal.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;
@Repository
public class TopicDaoImple  implements TopicDao{
    @Override
    public Boolean addTopicByUser(String name,String visibility, User user) {
        try {
            Session session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Visibility vis = Visibility.Public;
            if(visibility.equals("Private"))
                vis=Visibility.Private;
            else if(visibility.equals("Public"))
                vis=Visibility.Public;

            Topic topic =  new Topic();
            topic.setName(name);
            topic.setCreatedBy(user);
            topic.setDateCreated(new Date());
            topic.setVisibility(vis);
            session.save(topic);
            session.getTransaction().commit();

            return addsubscribe(user,topic);
        }catch (Exception e){
             e.printStackTrace();
             return false;
        }
    }

    public Boolean addsubscribe(User user,Topic topic){
        SubscriptionServices subscriptionServices = new SubscriptionServicesImple();
        return subscriptionServices.addSubscriber(user,topic);
    }
    @Override
    public Boolean validationOfTopicName(String name) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "SELECT name FROM Topic U  WHERE U.name = :name";
        Query query=session.createQuery(sql);
        query.setParameter("name",name);

        List<String> list=query.getResultList();
        for (String l:list){
            System.out.println(l);
        }
        if(list.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Topic getTopic(int topicId) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = " FROM Topic T WHERE T.topicId = :topicId";
        Query query=session.createQuery(sql);
        query.setParameter("topicId",topicId);
        Topic topic=  (Topic) query.getSingleResult();
        if(topic == null){
            return null;
        }else{
            return topic;
        }
    }
}
