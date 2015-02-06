package com.ronniegnr.app.controller.client;

import com.ronniegnr.app.service.PostService;
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
        /*
        Pageable pageable = new PageRequest(1, 1, new Sort(Sort.Direction.DESC, "id"));
        //model.addAttribute("posts", postService.getAllPost());
        model.addAttribute("posts", postRepository.findAll(pageable));*/

        model.addAttribute("posts", postService.getAllPost(pageNo));

        return this.VIEW_PATH + "blog";
    }

}
