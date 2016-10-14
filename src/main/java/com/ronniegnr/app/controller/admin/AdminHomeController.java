package com.ronniegnr.app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminHomeController {

    @RequestMapping(value = "/admin")
    public String Admin() {
        return "redirect:/admin/post/list";
    }

}
