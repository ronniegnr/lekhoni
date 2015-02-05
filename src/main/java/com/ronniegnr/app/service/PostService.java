package com.ronniegnr.app.service;

import com.ronniegnr.app.entity.Post;
import com.ronniegnr.app.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    public PostRepository postRepository;

    public Post getPost(int id) {
        return postRepository.findOne(id);
    }

    public List<Post> getAllPost() {
        return (List<Post>)postRepository.findAll();
    }

    public Post save(Post post) {
        post.setUpdated(new Timestamp(new Date().getTime()));
        return postRepository.save(post);
    }

    public void delete(int id) {
        postRepository.delete(id);
    }

}
