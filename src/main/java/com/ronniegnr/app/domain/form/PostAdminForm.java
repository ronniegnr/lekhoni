package com.ronniegnr.app.domain.form;

import com.ronniegnr.app.domain.entity.Post;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


public class PostAdminForm {

    private int id;
    private String title;
    private String value;
    private Post.Status status;
    private String tagIds;

    @NotNull
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotBlank
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotBlank
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @NotNull
    public Post.Status getStatus() {
        return status;
    }

    public void setStatus(Post.Status status) {
        this.status = status;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    @Override
    public String toString() {
        return "PostAdminForm{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", value='" + value + '\'' +
            ", status=" + status +
            ", tagIds='" + tagIds + '\'' +
            '}';
    }
}
