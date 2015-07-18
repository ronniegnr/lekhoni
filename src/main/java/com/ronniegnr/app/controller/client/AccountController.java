package com.ronniegnr.app.controller.client;

import com.ronniegnr.app.domain.form.UserSignupForm;
import com.ronniegnr.app.domain.validator.UserSignupValidator;
import com.ronniegnr.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSignupValidator userSignupValidator;

    private static final String VIEW_PATH = "client/account/";
    private static final String SIGNUP_PAGE = "/signup";
    private static final String LOGIN_PAGE = "/login";

    /*
    @InitBinder(value = "userSignupForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(userSignupValidator);
    }*/

    /*@ModelAttribute(value = "userSignupForm")
    public UserSignupForm generateUserSignupForm() {
        return new UserSignupForm();
    }*/

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String signup(UserSignupForm userSignupForm) {
        return this.VIEW_PATH + "login";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("userSignupForm") @Valid UserSignupForm userSignupForm, BindingResult bindingResult) {
        userSignupValidator.validate(userSignupForm, bindingResult);
        if(bindingResult.hasErrors()) {
            return this.VIEW_PATH + "login";
        }
        userService.createUser(userSignupForm);
        return "redirect:" + LOGIN_PAGE;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, @ModelAttribute("userSignupForm") UserSignupForm userSignupForm, Model model) {
        if(error != null) {
            model.addAttribute("message", "The email or password you have entered is invalid, try again.");
        }
        return this.VIEW_PATH + "login";
    }

}
