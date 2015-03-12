package com.ronniegnr.app.service;

import com.ronniegnr.app.entity.User;
import com.ronniegnr.app.entity.form.UserForm;
import com.ronniegnr.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component(value = "UserService")
class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(int id)
    {
        return userRepository.findOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>)userRepository.findAll();
    }

    /*
    @Override
    public void createUser(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPhone(userForm.getPhone());
    }*/

    @Override
    public void saveUser(User user)
    {
        user.setUpdated(new Timestamp(new Date().getTime()));
        userRepository.save(user);
    }
}
