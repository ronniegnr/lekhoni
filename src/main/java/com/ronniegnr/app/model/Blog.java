package com.ronniegnr.app.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "blog")
public class Blog {
    private int id;
    private int userId;
    private String title;
    private String content;
    private byte status;
    private Timestamp created;
    private Timestamp updated;

    private User user;
    private List<Tag> tags;

    public Blog() {}

    @Id
    @Column(name = "id", precision = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @Column(name = "user_id", precision = 20)
    //@JoinColumn(na)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Blog{" +
            "id=" + id +
            ", userId=" + userId +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", status=" + status +
            ", created=" + created +
            ", updated=" + updated +
            '}';
    }

}
