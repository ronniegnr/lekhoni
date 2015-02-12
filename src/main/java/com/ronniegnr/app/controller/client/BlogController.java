package com.ronniegnr.app.controller.client;

import com.ronniegnr.app.entity.Post;
import com.ronniegnr.app.service.PostService;
import com.ronniegnr.app.wrapper.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class BlogController {

    @Autowired
    private PostService postService;

    private static final String VIEW_PATH = "client/blog/";

    @RequestMapping("blog")
    public String blog() {
        return "redirect:/blog/1";
    }

    @RequestMapping("blog/{pageNo}")
    public String blog1(@PathVariable(value = "pageNo") int pageNo, Model model) {
        PageWrapper<Post> pagedPosts = new PageWrapper<Post>(postService.getPagedPost(pageNo), "/blog/");
        model.addAttribute("pagedPosts", pagedPosts);
        return this.VIEW_PATH + "blog";
    }

    @RequestMapping("blog/post/{postId}")
    public String post(@PathVariable(value = "postId") int postId, Model model) {
        model.addAttribute("post", postService.getPost(postId));
        return this.VIEW_PATH + "post";
    }

}
