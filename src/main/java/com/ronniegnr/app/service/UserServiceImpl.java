package com.ronniegnr.app.service;

import com.ronniegnr.app.domain.entity.User;
import com.ronniegnr.app.domain.form.UserAdminForm;
import com.ronniegnr.app.domain.form.UserSignupForm;
import com.ronniegnr.app.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component(value = "UserService")
class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(int id) {
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

    @Override
    public void createUser(UserSignupForm userSignupForm) {
        User user = new User();
        user.setName(userSignupForm.getName());
        user.setEmail(userSignupForm.getEmail());
        user.setPhone(userSignupForm.getPhone());
        user.setPassword(new BCryptPasswordEncoder().encode(userSignupForm.getPassword()));
        saveUser(user);
    }

    @Override
    public void createOrUpdateUser(UserAdminForm userAdminForm) {
        User user = new User();

        if(userAdminForm.getId() != 0) {
            user = getUserById(userAdminForm.getId());
        }
        user.setName(userAdminForm.getName());
        user.setEmail(userAdminForm.getEmail());
        user.setPhone(userAdminForm.getPhone());
        saveUser(user);
    }

    @Override
    public void saveUser(User user) {
        user.setUpdated(new Timestamp(new Date().getTime()));
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(id);
    }

}
