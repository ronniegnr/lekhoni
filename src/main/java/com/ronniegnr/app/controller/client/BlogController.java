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
public class BlogController {

    @Autowired
    private PostService postService;

    private static final String VIEW_PATH = "client/blog/";

    @RequestMapping("/blog/{pageNo}")
    public String blog(@PathVariable(value = "pageNo") int pageNo, Model model) {
        PageWrapper<Post> page = new PageWrapper<Post>(postService.getPagedPost(pageNo), "/blog/");
        model.addAttribute("posts", postService.getPagedPost(pageNo) );
        model.addAttribute("page", page);
        return this.VIEW_PATH + "blog";
    }

}
