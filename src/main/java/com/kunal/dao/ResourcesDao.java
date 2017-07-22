package com.kunal.dao;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;

public interface ResourcesDao {
    public Boolean addLinkResource(String description, User user, Topic topic,String url);
    public Boolean addDocumentPath(String description, User user, Topic topic,String filepath);
}
