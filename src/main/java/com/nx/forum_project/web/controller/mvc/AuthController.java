package com.nx.forum_project.web.controller.mvc;

import com.nx.forum_project.data.entity.User;
import com.nx.forum_project.web.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    /*
        Sign up = register your details for the first time

        Sign in = log in, notify someone of your arrival
     */


    @GetMapping("/registration")
    public String showRegistration(Model model) {

        model.addAttribute("user", new User());

        return "auth/registration";
    }

    @GetMapping("/login")
    public String showLogin(@RequestParam(name = "error", required = false) Boolean error, Model model) {

        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        return "auth/login";
    }

//    @GetMapping("/logout")
//    public String showLogout(Model model) {
//
//        model.addAttribute("user", new User());
//
//        return "auth/logout";
//    }
}
