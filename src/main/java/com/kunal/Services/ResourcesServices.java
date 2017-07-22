package com.kunal.Services;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface ResourcesServices {
    public Boolean addLinkResource(String description, User user, Topic topic, String url);

    public Boolean addDocumentPath(String description, User user, Topic topic,String filepath);
}
