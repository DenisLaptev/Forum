package com.nx.forum_project.web.controller.mvc;

import com.nx.forum_project.data.entity.User;
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

    // We validate the User bean with @Valid.
    // The validation results are stored in BindingResult


    @GetMapping("/registration-form")
    public String showRegistrationForm(Model model) {

        model.addAttribute("user", new User());

        return "auth/registrationForm";
    }

    @GetMapping("/registration-info")
    public String showRegistrationInfo() {

        return "auth/registrationInfo";
    }

    @GetMapping("/login")
    public String showLogin(@RequestParam(name = "error", required = false) Boolean error, Model model) {

        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        return "auth/login";
    }

}
