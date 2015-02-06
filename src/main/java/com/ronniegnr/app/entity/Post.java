package com.ronniegnr.app.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String value;
    private Status status;
    private Timestamp created;
    private Timestamp updated;

    private User user;
    private List<Tag> tags;
    private List<Comment> comments;

    private int valueShort;
    private int commentCount;

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
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @NotNull
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
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

    @Transient
    public String getValueShort() {
        int valueLength = getValue().length();
        return getValue().substring(0, valueLength > 500 ? 500 : valueLength) + "...";
    }

    @Transient
    public int getCommentCount() {
        return getComments().size();
    }

    @Override
    public String toString() {
        return "Blog{" +
            "id=" + id +
            ", userId=" + userId +
            ", title='" + title + '\'' +
            ", content='" + value + '\'' +
            ", status=" + status +
            ", created=" + created +
            ", updated=" + updated +
            '}';
    }

}
