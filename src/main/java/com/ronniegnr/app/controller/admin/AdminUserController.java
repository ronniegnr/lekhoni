package com.ronniegnr.app.controller.admin;

import com.ronniegnr.app.entity.Post;
import com.ronniegnr.app.entity.User;
import com.ronniegnr.app.entity.form.UserAdminForm;
import com.ronniegnr.app.entity.form.UserSignupForm;
import com.ronniegnr.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/user/")
public class AdminUserController {

    @Autowired
    private UserService userService;

    private static final String VIEW_PATH = "admin/user/";

    private static final String LIST_PAGE = "/admin/user/list";
    private static final String ENTRY_PAGE = "/admin/user/entry";
    private static final String EDIT_PAGE = "/admin/user/edit";

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return this.VIEW_PATH + "list";
    }

    @RequestMapping(value = "entry", method = RequestMethod.GET)
    public String entry() {
        return this.VIEW_PATH + "entry";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable(value = "id") int id, Model model) {

        UserAdminForm userAdminForm = userService.getUserById(id).toUserAdminForm();
        System.out.println(userAdminForm.toString());

        model.addAttribute("userAdminForm", userService.getUserById(id).toUserAdminForm());

        return this.VIEW_PATH + "edit";
    }

    @RequestMapping(value = "save/{id}", method = RequestMethod.POST)
    public String save(@Valid UserAdminForm userAdminForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return this.VIEW_PATH + (userAdminForm.getId() == 0 ? "entry" : "edit");
        }
        else {
            userService.createOrUpdateUser(userAdminForm);
            return "redirect:" + this.LIST_PAGE;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") int id) {
        userService.deleteUser(id);
        return "redirect:" + this.LIST_PAGE;
    }

}
