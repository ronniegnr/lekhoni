package com.ronniegnr.app.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class AccountController {

    private static final String VIEW_PATH = "client/account/";

    @RequestMapping(value = "signup")
    public String signup() {
        return this.VIEW_PATH + "signup";
    }

}
