package com.ronniegnr.app.service;

import com.ronniegnr.app.domain.common.CurrentUser;
import com.ronniegnr.app.domain.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CurrentUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUser(email);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("User with email=%s was not found", email));
        }
        return new CurrentUser(user);
    }

}
