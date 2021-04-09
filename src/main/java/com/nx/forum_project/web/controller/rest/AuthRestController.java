package com.nx.forum_project.web.controller.rest;

import com.nx.forum_project.data.entity.User;
import com.nx.forum_project.web.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestController {

    /*
        Sign up = register your details for the first time

        Sign in = log in, notify someone of your arrival
     */

    @Autowired
    @Qualifier("UserServiceSpringDataImpl")
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<User> register(@RequestBody User entity) {

        userService.create(entity);
        return ResponseEntity.ok(entity);
    }
}
