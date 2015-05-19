package com.ronniegnr.app.repository;

import com.ronniegnr.app.domain.entity.Post;
import com.ronniegnr.app.domain.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {

    Page<Post> findByStatus(Post.Status status, Pageable pageable);
    Page<Post> findByTagsAndStatus(List<Tag> tags, Post.Status status, Pageable pageable);

}
