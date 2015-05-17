package com.ronniegnr.app.service;

import com.ronniegnr.app.domain.adapter.PostAdapter;
import com.ronniegnr.app.domain.entity.Post;
import com.ronniegnr.app.domain.entity.Tag;
import com.ronniegnr.app.domain.form.PostAdminForm;
import com.ronniegnr.app.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    public PostRepository postRepository;
    @Autowired
    private PostAdapter postAdapter;

    @Autowired
    public UserService userService;
    @Autowired
    public TagService tagService;


    private static final int PER_PAGE_DATA = 10;

    public Post getPost(int id) {
        return postRepository.findOne(id);
    }

    public List<Post> getAllPost() {
        return (List<Post>)postRepository.findAll();
    }

    public PostAdminForm getPostAdminForm(int id) {
        return postAdapter.toPostAdminForm(getPost(id));
    }

    public Page<Post> getPagedPost(Post.Status status, int pageNo) {
        Pageable pageable = new PageRequest(pageNo-1, PER_PAGE_DATA, new Sort(Sort.Direction.DESC, "id"));
        //return postRepository.findAll(pageable);
        return postRepository.findByStatus(status, pageable);
    }

    public Page<Post> getPagedPost(String tagValue, Post.Status status, int pageNo) {
        Pageable pageable = new PageRequest(pageNo-1, PER_PAGE_DATA, new Sort(Sort.Direction.DESC, "id"));
        List<Tag> tags = new ArrayList<Tag>();
        Tag tag = tagService.getTag(tagValue);
        if(tag != null) {
            tags.add(tag);
        }
        return postRepository.findByStatusAndTags(tags, status, pageable);
    }

    public Post save(Post post) {
        post.setUpdated(new Timestamp(new Date().getTime()));
        post.setUser(userService.getUser(2));
        return postRepository.save(post);
    }

    public Post save(PostAdminForm postAdminForm) {
        Post post = postAdapter.toPost(postAdminForm);
        return save(post);
    }

    public void delete(int id) {
        postRepository.delete(id);
    }

}
