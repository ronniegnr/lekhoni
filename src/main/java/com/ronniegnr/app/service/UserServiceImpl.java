package com.ronniegnr.app.service;

import com.ronniegnr.app.entity.User;
import com.ronniegnr.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.util.Date;

@Component(value = "UserService")
class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(int id)
    {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User user)
    {
        user.setUpdated(new Timestamp(new Date().getTime()));
        userRepository.save(user);
    }
}
