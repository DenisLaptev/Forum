package com.nx.forum_project.web.controller.rest;

import com.nx.forum_project.data.entity.Role;
import com.nx.forum_project.web.service.interf.CRUDService;
import com.nx.forum_project.web.service.interf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CRUDRestController.ROLE_URL)
public class RoleRestController extends CRUDRestController<Role, Long> {

    @Autowired
    @Qualifier("RoleServiceSpringDataImpl")
    private RoleService roleService;

    @Override
    CRUDService<Role, Long> getService() {
        return roleService;
    }
}
