package com.ronniegnr.app.domain.adapter;

import com.ronniegnr.app.domain.entity.Post;
import com.ronniegnr.app.domain.entity.Tag;
import com.ronniegnr.app.domain.form.PostAdminForm;
import com.ronniegnr.app.service.PostService;
import com.ronniegnr.app.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostAdapter {

    @Autowired
    private PostService postService;
    @Autowired
    private TagService tagService;

    public PostAdminForm toPostAdminForm(Post post) {
        PostAdminForm postAdminForm = new PostAdminForm();

        postAdminForm.setId(post.getId());
        postAdminForm.setTitle(post.getTitle());
        postAdminForm.setValue(post.getValue());
        postAdminForm.setStatus(post.getStatus());

        String tagIds = new String();
        for(Tag tag : post.getTags()) {
            tagIds += tag.getId() + ",";
        }
        postAdminForm.setTagIds(tagIds);

        return postAdminForm;
    }

    public Post toPost(PostAdminForm postAdminForm) {
        Post post = postService.getPost(postAdminForm.getId());

        if(post == null) {
            post = new Post();
        }

        post.setId(postAdminForm.getId());
        post.setTitle(postAdminForm.getTitle());
        post.setValue(postAdminForm.getValue());
        post.setStatus(postAdminForm.getStatus());

        List<Tag> tags = new ArrayList<Tag>();
        String[] tagIds = postAdminForm.getTagIds().split(",");

        for(String tagId : tagIds) {
            if(tagId.trim().length() > 0) {
                try {
                    Tag tag = tagService.getTag(Integer.parseInt(tagId));
                    if (tag != null) {
                        tags.add(tag);
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
        post.setTags(tags);

        return post;

    }

}
