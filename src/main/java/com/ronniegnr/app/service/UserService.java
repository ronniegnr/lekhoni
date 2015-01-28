package com.ronniegnr.app.service;

import com.ronniegnr.app.model.User;

public interface UserService {
    User getUser(int id);
    void save(User user);
}
