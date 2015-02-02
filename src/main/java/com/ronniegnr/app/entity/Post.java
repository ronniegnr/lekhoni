package com.ronniegnr.app.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    public enum Status { ACTIVE, INACTIVE };

    private int id;
    private int userId;
    private String title;
    private String content;
    private Status status;
    private Timestamp created;
    private Timestamp updated;

    private User user;
    private List<Tag> tags;
    private List<Comment> comments;

    public Post() {
        this.status = Status.ACTIVE;
        this.created = this.updated = new Timestamp(new Date().getTime());
    }

    @Id
    @NotNull
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "user_id", updatable = false, insertable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @NotBlank
    @Length(max = 1023)
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotBlank
    @Length(max = 65535)
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @NotNull
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @NotNull
    @Column(name = "updated")
    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany
    @JoinTable(name = "post_tag", joinColumns = {@JoinColumn(name = "post_id", insertable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "tag_id", insertable = false, updatable = false)})
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @OneToMany(mappedBy = "post")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
