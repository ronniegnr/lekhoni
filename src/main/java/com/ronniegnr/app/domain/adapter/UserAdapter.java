package com.ronniegnr.app.domain.adapter;

import com.ronniegnr.app.domain.entity.User;
import com.ronniegnr.app.domain.form.UserAdminForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {

    public UserAdminForm toUserAdminForm(User user) {
        UserAdminForm userAdminForm = new UserAdminForm();

        userAdminForm.setId(user.getId());
        userAdminForm.setName(user.getName());
        userAdminForm.setEmail(user.getEmail());
        userAdminForm.setPhone(user.getPhone());
        userAdminForm.setStatus(user.getStatus());

        return userAdminForm;
    }

    public User toUser(UserAdminForm userAdminForm) {
        User user = new User();

        user.setId(userAdminForm.getId());
        user.setName(userAdminForm.getName());
        user.setEmail(userAdminForm.getEmail());
        user.setPhone(userAdminForm.getPhone());
        user.setStatus(userAdminForm.getStatus());
        if(!userAdminForm.getPassword().isEmpty()) {
            user.setPassword(new BCryptPasswordEncoder().encode(userAdminForm.getPassword()));
        }

        return user;
    }

}
