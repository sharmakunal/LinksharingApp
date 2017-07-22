package com.kunal.dao;

import com.kunal.Entity.DocumentResources;
import com.kunal.Entity.LinkResources;
import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import com.kunal.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public class ResourceDaoImple implements ResourcesDao{
    @Override
    public Boolean addLinkResource(String description, User user, Topic topic, String url) {
        try {
            Session session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            LinkResources linkResources = new LinkResources();
            linkResources.setDescription(description);
            linkResources.setUrl(url);
            linkResources.setCreatedby(user);
            linkResources.setTopic(topic);
            linkResources.setDateCreated(new Date());
            session.save(linkResources);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean addDocumentPath(String description, User user, Topic topic, String filepath) {
        try {
            Session session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            DocumentResources documentResources = new DocumentResources();
            documentResources.setDescription(description);
            documentResources.setFilePath(filepath);
            documentResources.setCreatedby(user);
            documentResources.setTopic(topic);
            documentResources.setDateCreated(new Date());
            session.save(documentResources);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
