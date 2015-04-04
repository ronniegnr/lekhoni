package com.ronniegnr.app.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    private static final String VIEW_PATH = "client/";

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/blog";
        //return this.VIEW_PATH + "home";
    }

}
