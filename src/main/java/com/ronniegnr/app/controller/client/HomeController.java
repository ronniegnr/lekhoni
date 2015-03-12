package com.ronniegnr.app.controller.client;

//import main.java.com.ronniegnr.app.service.BlogService;
import com.ronniegnr.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserService usService;

    private static final String VIEW_PATH = "client/";

    @RequestMapping(value = "/")
    public String home() {
        return this.VIEW_PATH + "home";
    }







}
