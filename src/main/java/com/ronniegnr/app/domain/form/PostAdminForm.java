package com.ronniegnr.app.domain.form;

import com.ronniegnr.app.domain.entity.Post;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


public class PostAdminForm {

    private int id;
    private String title;
    private String valueHtml;
    private String valueMarkdown;
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
    public String getValueHtml() {
        return valueHtml;
    }

    public void setValueHtml(String valueHtml) {
        this.valueHtml = valueHtml;
    }

    public String getValueMarkdown() {
        return valueMarkdown;
    }

    public void setValueMarkdown(String valueMarkdown) {
        this.valueMarkdown = valueMarkdown;
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
            ", valueHtml='" + valueHtml + '\'' +
            ", valueMarkdown='" + valueMarkdown + '\'' +
            ", status=" + status +
            ", tagIds='" + tagIds + '\'' +
            '}';
    }
}
