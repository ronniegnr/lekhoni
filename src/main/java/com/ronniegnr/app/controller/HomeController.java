package com.ronniegnr.app.controller;

import com.ronniegnr.app.model.User;
import com.ronniegnr.app.model.Post;
//import main.java.com.ronniegnr.app.service.BlogService;
import com.ronniegnr.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping("/user")
    public String user()
    {

        //Blog blog = new Blog();

        return userService.getUser(1).toString();
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test()
    {
        User user = new User();
        user.setName("Ronnie");
        user.setPassword("this");
        user.setEmail("asdf");
        user.setPhone("456123");
        userService.save(user);

        return user.toString();
    }

}
