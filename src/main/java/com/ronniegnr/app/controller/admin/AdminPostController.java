package com.ronniegnr.app.controller.admin;

import com.ronniegnr.app.domain.adapter.PostAdapter;
import com.ronniegnr.app.domain.form.PostAdminForm;
import com.ronniegnr.app.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/post")
public class AdminPostController {

    @Autowired
    private PostService postService;

    private static final String VIEW_PATH = "admin/post/";

    private static final String LIST_PAGE = VIEW_PATH + "list";
    private static final String ENTRY_PAGE = VIEW_PATH + "entry";
    private static final String EDIT_PAGE = VIEW_PATH + "edit";

    @RequestMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("posts", postService.getAllPost());
        return LIST_PAGE;
    }

    @RequestMapping(value = "entry", method = RequestMethod.GET)
    public String showEntryForm(PostAdminForm postAdminForm) {
        return ENTRY_PAGE;
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("postAdminForm", postService.getPostAdminForm(id) );
        return EDIT_PAGE;
    }

    @RequestMapping(value = "save/{id}", method = RequestMethod.POST)
    public String saveForm(@Valid PostAdminForm postAdminForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return (postAdminForm.getId() == 0 ? ENTRY_PAGE : EDIT_PAGE);
        }
        else {
            postService.save(postAdminForm);
            return "redirect:/" + LIST_PAGE;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") int id) {
        postService.delete(id);
        return "redirect:/" + LIST_PAGE;
    }

}
