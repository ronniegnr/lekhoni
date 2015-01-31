package com.ronniegnr.app.service;

import com.ronniegnr.app.entity.Post;
import com.ronniegnr.app.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;

public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post getPost(int id) {
        return postRepository.findOne(id);
    }

    public Post Save(Post post) {
        post.setUpdated(new Timestamp(new Date().getTime()));
        return postRepository.save(post);
    }

}
