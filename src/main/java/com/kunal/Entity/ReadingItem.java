package com.kunal.Entity;
import javax.persistence.*;

@Entity
@Table
public class ReadingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int readingitemId;
    @OneToOne
    private User user;
    @OneToOne
    private Resources resources;
    private Boolean isRead;

    public int getReadingitemId() {
        return readingitemId;
    }

    public void setReadingitemId(int readingitemId) {
        this.readingitemId = readingitemId;
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

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }
}
