package jm.fatumepta.springmvc.app.controller;

import jm.fatumepta.springmvc.app.model.User;
import jm.fatumepta.springmvc.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping({"/", "/home"})
    public String showHomePage(Model model) {
        return "home";
    }

    @GetMapping("/admin/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list-of-users";
    }

    @GetMapping("/admin/showUserForm")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @GetMapping("/admin/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-form";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(userService.getUserById(id));
        return "redirect:/admin/users";
    }

    @PostMapping("/admin/saveOrUpdateUser")
    public String saveOrUpdateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-form";
        } else {
            userService.saveUser(user);
            return "redirect:/admin/users";
        }
    }

}
