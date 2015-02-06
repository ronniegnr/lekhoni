package com.ronniegnr.app.repository;

import com.ronniegnr.app.entity.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {

}
