package com.ronniegnr.app.service;

import com.ronniegnr.app.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(int id);
    User getUserByEmail(String email);
    List<User> getAllUser();

    void saveUser(User user);

}
