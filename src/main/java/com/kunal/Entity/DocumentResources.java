package com.kunal.Entity;

import javax.persistence.Entity;

@Entity
public class DocumentResources extends Resources{

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
