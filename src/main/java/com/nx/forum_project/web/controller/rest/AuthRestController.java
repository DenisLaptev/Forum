package com.nx.forum_project.web.controller.rest;

import com.nx.forum_project.data.entity.User;
import com.nx.forum_project.web.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthRestController {

    /*
        Sign up = register your details for the first time
        Sign in = log in, notify someone of your arrival
     */

    @Autowired
    @Qualifier("UserServiceSpringDataImpl")
    private UserService userService;



    @PostMapping("/registration-validate")
    public ResponseEntity<User> validateRegistration(@Valid @RequestBody User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(user);
    }


    @PostMapping("/registration-do")
    public ResponseEntity<User> register(@RequestBody User user) {

        userService.create(user);

        return ResponseEntity.ok(user);
    }

}
