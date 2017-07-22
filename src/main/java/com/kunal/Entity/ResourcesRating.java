package com.kunal.Entity;

import javax.persistence.*;

@Entity
@Table
public class ResourcesRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resourcesratingId;
    @OneToOne
    private User user;
    @OneToOne
    private Resources resources;
    private Integer Score;

    public int getResourcesratingId() {
        return resourcesratingId;
    }

    public void setResourcesratingId(int resourcesratingId) {
        this.resourcesratingId = resourcesratingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

    @Override
    public String toString() {
        return "ResourcesRating{" +
                "user=" + user +
                ", resources=" + resources +
                ", Score=" + Score +
                '}';
    }
}
