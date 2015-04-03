package com.ronniegnr.app.controller.admin;

import com.ronniegnr.app.domain.entity.Post;
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

    private static final String LIST_PAGE = "/admin/post/list";
    private static final String ENTRY_PAGE = "/admin/post/entry";
    private static final String EDIT_PAGE = "/admin/post/edit";

    @RequestMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("posts", postService.getAllPost());
        return this.VIEW_PATH + "list";
    }

    @RequestMapping(value = "entry", method = RequestMethod.GET)
    public String showEntryForm(Post post) {
        return this.VIEW_PATH + "entry";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("post", postService.getPost(id));
        return this.VIEW_PATH + "edit";
    }

    @RequestMapping(value = "save/{id}", method = RequestMethod.POST)
    public String saveForm(@Valid Post post, BindingResult bindingResult) {
        post.setUser(userService.getUserById(2));
        if(bindingResult.hasErrors()) {
            return this.VIEW_PATH + (post.getId() == 0 ? "entry" : "edit");
        }
        else {
            postService.save(post);
            return "redirect:" + this.LIST_PAGE;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") int id) {
        postService.delete(id);
        return "redirect:" + this.LIST_PAGE;
    }

}
