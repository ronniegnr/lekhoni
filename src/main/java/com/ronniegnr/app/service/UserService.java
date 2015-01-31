package com.ronniegnr.app.service;

import com.ronniegnr.app.entity.User;

public interface UserService {
    User getUser(int id);
    void save(User user);
}
