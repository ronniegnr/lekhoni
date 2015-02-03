package com.ronniegnr.app.controller.admin;

import com.ronniegnr.app.entity.Post;
import com.ronniegnr.app.service.PostService;
import com.ronniegnr.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/post/")
public class AdminPostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    private static final String VIEW_PATH = "admin/post/";

    @RequestMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("posts", postService.getAllPost());
        return this.VIEW_PATH + "postlist";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createShowForm(Post post) {
        return this.VIEW_PATH + "postcreate";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createSaveForm(@Valid Post post, BindingResult bindingResult) {
        post.setUser(userService.getUser(2));
        if(bindingResult.hasErrors()) {
            return this.VIEW_PATH + "postcreate";
        }
        else {
            postService.save(post);
            return "redirect:/admin/post/list";
        }
    }

    @ModelAttribute
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String updateShowForm(Post post) {
        return this.VIEW_PATH = "postupdate";
    }
}
