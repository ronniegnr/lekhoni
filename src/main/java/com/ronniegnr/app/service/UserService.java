package com.ronniegnr.app.service;

import com.ronniegnr.app.domain.entity.User;
import com.ronniegnr.app.domain.form.UserSignupForm;
import com.ronniegnr.app.domain.form.UserAdminForm;

import java.util.List;

public interface UserService {

    User getUser(int id);
    UserAdminForm getUserAdminForm(int id);
    User getUser(String email);
    List<User> getAllUser();

    void createUser(UserSignupForm userSignupForm);
    User save(User user);
    User save(UserAdminForm userAdminForm);
    void deleteUser(int id);
}
