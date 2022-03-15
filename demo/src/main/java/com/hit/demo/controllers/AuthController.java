package com.hit.demo.controllers;

import com.hit.demo.models.Store;
import com.hit.demo.models.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private static boolean axits = false;
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("mess", axits);
        return "login";
    }

    @PostMapping("/users")
    public String listLogin(@ModelAttribute User user, Model model) {
        if(Store.checkAccount(user)) {
            model.addAttribute("users", Store.users);
            return "users";
        }
        axits = true;
        return "redirect:login";
    }
}
