package com.nx.forum_project.web.controller.mvc;

import com.nx.forum_project.data.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(CRUDController.USER_URL_MVC)
public class UserController extends CRUDController<User, Long> {

    @Override
    String getEntityName() {
        return CRUDController.USER_NAME;
    }
}