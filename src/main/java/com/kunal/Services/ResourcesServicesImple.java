package com.kunal.Services;

import com.kunal.Entity.Topic;
import com.kunal.Entity.User;
import com.kunal.dao.ResourceDaoImple;
import com.kunal.dao.ResourcesDao;
import org.springframework.stereotype.Service;

@Service
public class ResourcesServicesImple  implements ResourcesServices {

    ResourcesDao resourcesDao = new ResourceDaoImple();

    @Override
    public Boolean addLinkResource(String description, User user, Topic topic, String url) {
        return resourcesDao.addLinkResource(description,user,topic,url);
    }

    @Override
    public Boolean addDocumentPath(String description, User user, Topic topic, String filepath) {
        return resourcesDao.addDocumentPath(description,user,topic,filepath);
    }
}
