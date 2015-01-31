package com.ronniegnr.app.repository;

import com.ronniegnr.app.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
