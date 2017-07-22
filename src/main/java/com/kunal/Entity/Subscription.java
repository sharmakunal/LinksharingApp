package com.kunal.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subscriptionId;
    @ManyToOne
    private Topic topic;
    @ManyToOne
    private User user;
    private Date dateCreated;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Seriousness seriousness ;

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Seriousness getSeriousness() {
        return seriousness;
    }

    public void setSeriousness(Seriousness seriousness) {
        this.seriousness = seriousness;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "topic=" + topic +
                ", user=" + user +
                ", seriousness=" + seriousness +
                '}';
    }
}
