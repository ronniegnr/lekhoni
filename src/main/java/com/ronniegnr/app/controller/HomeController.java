package com.ronniegnr.app.controller;

import com.ronniegnr.app.entity.User;
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
    private UserService usService;

    @RequestMapping("/")
    public String home() {
        return "home";
    }



    @RequestMapping("/test2")
    public String index2(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "pindex";
    }

    @RequestMapping("/user")
    public String user()
    {

        //Blog blog = new Blog();

        return usService.getUser(1).toString();
    }

    @RequestMapping("/test")
    //@ResponseBody
    public String test()
    {
        /*
        User user = new User();
        user.setName("Ronnie");
        user.setPassword("this");
        user.setEmail("asdf");
        user.setPhone("456123");
        user.setStatus(User.Status.PENDING);
        usService.save(user);

        return usService.getUser(2).toString();*/

        return "home";
    }

}
