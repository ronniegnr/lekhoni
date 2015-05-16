package com.ronniegnr.app.repository;

import com.ronniegnr.app.domain.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;

public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {
    Page<Post> findByStatus(Post.Status status, Pageable pageable);
}
