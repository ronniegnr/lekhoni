package com.ronniegnr.app.domain.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tag")
public class Tag {

    private int id;
    private String name; // this will be show in the page
    private String value; // this will be used as URL parameter
    private Timestamp created;
    private Timestamp updated;

    private List<Post> posts;
    private int postCount;

    public Tag() {
        this.created = this.updated = new Timestamp(new Date().getTime());
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Length(max = 255)
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Length(max = 255)
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    @ManyToMany(mappedBy = "tags")
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Transient
    public int getPostCount() {
        return getPosts().size();
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    @Override
    public String toString() {
        return "Tag{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", value='" + value + '\'' +
            ", created=" + created +
            ", updated=" + updated +
            ", posts=" + posts +
            ", postCount=" + postCount +
            '}';
    }
}
