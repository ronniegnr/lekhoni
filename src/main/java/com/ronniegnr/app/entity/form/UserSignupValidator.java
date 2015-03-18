package com.ronniegnr.app.entity.form;

import com.ronniegnr.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserSignupValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserSignupForm.class);
    }

    @Override
    public void validate(Object object, Errors errors) {
        UserSignupForm userSignupForm = (UserSignupForm)object;
        validatePasswords(errors, userSignupForm);
        validateEmail(errors, userSignupForm);
    }

    private void validatePasswords(Errors erros, UserSignupForm userSignupForm) {
        if(!userSignupForm.getPassword().equals(userSignupForm.getRepeatedPassword())) {
            erros.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateEmail(Errors errors, UserSignupForm userSignupForm) {
        if(userService.getUserByEmail(userSignupForm.getEmail()) != null) {
            errors.reject("email.exists", "User with this email address already exists");
        }
    }

}
