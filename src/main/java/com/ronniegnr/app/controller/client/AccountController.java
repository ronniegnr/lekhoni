package com.ronniegnr.app.controller.client;

import com.ronniegnr.app.entity.form.UserSignupForm;
import com.ronniegnr.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/")
public class AccountController {

    @Autowired
    private UserService userService;

    private static final String VIEW_PATH = "client/account/";

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String signup() {
        return this.VIEW_PATH + "login";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signupPost(@Valid @ModelAttribute("userForm") UserSignupForm userForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "redirect:/signup";
        }

        userService.createUser(userForm);
        return this.VIEW_PATH + "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return this.VIEW_PATH + "login";
    }

}
