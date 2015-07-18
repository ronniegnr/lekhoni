package com.ronniegnr.app.controller.admin;

import com.ronniegnr.app.domain.form.UserAdminForm;
import com.ronniegnr.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    private static final String VIEW_PATH = "admin/user/";

    private static final String LIST_PAGE = VIEW_PATH + "list";
    private static final String ENTRY_PAGE = VIEW_PATH + "entry";
    private static final String EDIT_PAGE = VIEW_PATH + "edit";

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
        model.addAttribute("userAdminForm", userService.getUserAdminForm(id));
        return this.VIEW_PATH + "edit";
    }

    @RequestMapping(value = "save/{id}", method = RequestMethod.POST)
    public String save(@Valid UserAdminForm userAdminForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return this.VIEW_PATH + (userAdminForm.getId() == 0 ? "entry" : "edit");
        }
        else {
            userService.save(userAdminForm);
            return "redirect:" + this.LIST_PAGE;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") int id) {
        userService.deleteUser(id);
        return "redirect:" + this.LIST_PAGE;
    }

}
