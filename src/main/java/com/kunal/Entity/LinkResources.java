package com.kunal.Entity;

import javax.persistence.Entity;

@Entity
public class LinkResources  extends Resources{

  private String url;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
