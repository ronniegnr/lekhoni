package com.ronniegnr.app.service;

import com.ronniegnr.app.domain.entity.Post;
import com.ronniegnr.app.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    public PostRepository postRepository;

    private static final int PER_PAGE_DATA = 10;

    public Post getPost(int id) {
        return postRepository.findOne(id);
    }

    public List<Post> getAllPost() {
        return (List<Post>)postRepository.findAll();
    }

    public Page<Post> getPagedPost(int pageNo) {
        Pageable pageable = new PageRequest(pageNo-1, PER_PAGE_DATA, new Sort(Sort.Direction.DESC, "id"));
        return postRepository.findAll(pageable);
    }

    public Post save(Post post) {
        post.setUpdated(new Timestamp(new Date().getTime()));
        return postRepository.save(post);
    }

    public void delete(int id) {
        postRepository.delete(id);
    }

}
