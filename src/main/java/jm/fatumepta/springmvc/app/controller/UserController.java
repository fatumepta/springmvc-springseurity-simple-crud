package jm.fatumepta.springmvc.app.controller;

import jm.fatumepta.springmvc.app.model.User;
import jm.fatumepta.springmvc.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list-of-users";
    }

    @GetMapping("/showUserForm")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(userService.getUserById(id));
        return "redirect:/";
    }

    @PostMapping("/saveOrUpdateUser")
    public String saveOrUpdateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

}
