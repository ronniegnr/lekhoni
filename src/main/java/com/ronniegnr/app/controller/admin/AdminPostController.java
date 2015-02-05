package com.ronniegnr.app.controller.admin;

import com.ronniegnr.app.entity.Post;
import com.ronniegnr.app.service.PostService;
import com.ronniegnr.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(value = "entry", method = RequestMethod.GET)
    public String showEntryForm(Post post) {
        return this.VIEW_PATH + "postentry";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("post", postService.getPost(id));
        return this.VIEW_PATH + "postedit";
    }

    @RequestMapping(value = "save/{id}", method = RequestMethod.POST)
    public String saveForm(@Valid Post post, BindingResult bindingResult) {
        post.setUser(userService.getUser(2));
        if(bindingResult.hasErrors()) {
            return this.VIEW_PATH + (post.getId() == 0 ? "postentry" : "postedit");
        }
        else {
            postService.save(post);
            return "redirect:/admin/post/list";
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") int id) {
        postService.delete(id);
        return "redirect:/admin/post/list";
    }



}
