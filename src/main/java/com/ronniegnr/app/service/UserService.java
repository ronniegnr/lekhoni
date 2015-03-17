package com.ronniegnr.app.service;

import com.ronniegnr.app.entity.User;
import com.ronniegnr.app.entity.form.UserSignupForm;
import com.ronniegnr.app.entity.form.UserAdminForm;

import java.util.List;

public interface UserService {

    User getUserById(int id);
    User getUserByEmail(String email);
    List<User> getAllUser();

    void createUser(UserSignupForm userSignupForm);
    void createOrUpdateUser(UserAdminForm userAdminForm);
    void saveUser(User user);
    void deleteUser(int id);
}
