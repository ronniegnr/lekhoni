package com.ronniegnr.app.service;

import com.ronniegnr.app.domain.adapter.UserAdapter;
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
    @Autowired
    private UserAdapter userAdapter;

    @Override
    public User getUser(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public UserAdminForm getUserAdminForm(int id) {
        return userAdapter.toUserAdminForm(getUser(id));
    }

    @Override
    public User getUser(String email) {
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
        save(user);
    }

    @Override
    public User save(User user) {
        user.setUpdated(new Timestamp(new Date().getTime()));
        return userRepository.save(user);
    }

    @Override
    public User save(UserAdminForm userAdminForm) {
        User user = userAdapter.toUser(userAdminForm);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(id);
    }

}
