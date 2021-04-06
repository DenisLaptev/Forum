package com.nx.forum_project.web.controller.mvc;

import com.nx.forum_project.data.entity.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(CRUDController.ROLE_URL_MVC)
public class RoleController extends CRUDController<Role, Long> {

    @Override
    String getEntityName() {
        return CRUDController.ROLE_NAME;
    }
}