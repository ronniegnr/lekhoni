package com.ronniegnr.app.repository;

import com.ronniegnr.app.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findById(int id);
    User findByEmail(String email);
}
