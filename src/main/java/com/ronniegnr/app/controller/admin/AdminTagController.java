package com.ronniegnr.app.controller.admin;

import com.ronniegnr.app.domain.entity.Tag;
import com.ronniegnr.app.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/tag")
public class AdminTagController {

    @Autowired
    private TagService tagService;

    private static final String VIEW_PATH = "admin/tag/";
    private static final String LIST_PAGE = VIEW_PATH + "list";
    private static final String ENTRY_PAGE = VIEW_PATH + "entry";
    private static final String EDIT_PAGE = VIEW_PATH + "edit";

    @RequestMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("tags", tagService.getAllTag());
        return LIST_PAGE;
    }

    @RequestMapping(value = "entry", method = RequestMethod.GET)
    public String showEntryForm(Tag tag) {
        return ENTRY_PAGE;
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));
        return EDIT_PAGE;
    }

    @RequestMapping(value = "save/{id}", method = RequestMethod.POST)
    public String saveForm(@Valid Tag tag, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return tag.getId() == 0 ? ENTRY_PAGE : EDIT_PAGE;
        }
        else {
            tagService.save(tag);
            return "redirect:" + this.LIST_PAGE;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") int id) {
        tagService.delete(id);
        return "redirect:" + this.LIST_PAGE;
    }

}
