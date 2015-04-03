package com.ronniegnr.app.domain.common;

import com.ronniegnr.app.domain.entity.User;

import org.springframework.security.core.authority.AuthorityUtils;


public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    private User getUser() {
        return user;
    }

    private int getId() {
        return user.getId();
    }

    private User.Role getRole() {
        return user.getRole();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
            "user=" + user +
            '}';
    }
}
