package jm.fatumepta.springmvc.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    // show all users
    @GetMapping("/")
    public String showListOfUsers(Model model) {
        return "list-of-users";
    }

    // show user form (add/edit)
    @GetMapping("/user-form")
    public String showUserForm() {
        return "user-form";
    }

    // send form with user data
    @PostMapping("/user-form")
    public String processUserForm() {
        return "list-of-users";
    }

}
