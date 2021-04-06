package com.nx.forum_project.web.controller.rest;

import com.nx.forum_project.data.entity.User;
import com.nx.forum_project.web.service.interf.CRUDService;
import com.nx.forum_project.web.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CRUDRestController.USER_URL)
public class UserRestController extends CRUDRestController<User, Long> {

    @Autowired
    @Qualifier("UserServiceSpringDataImpl")
    private UserService userService;

    @Override
    CRUDService<User, Long> getService() {
        return userService;
    }
}
