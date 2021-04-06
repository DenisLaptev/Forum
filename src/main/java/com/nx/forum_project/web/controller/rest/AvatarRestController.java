package com.nx.forum_project.web.controller.rest;

import com.nx.forum_project.data.entity.Avatar;
import com.nx.forum_project.web.service.interf.AvatarService;
import com.nx.forum_project.web.service.interf.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CRUDRestController.AVATAR_URL)
public class AvatarRestController extends CRUDRestController<Avatar, Long> {

    @Autowired
    @Qualifier("AvatarServiceSpringDataImpl")
    private AvatarService avatarService;

    @Override
    CRUDService<Avatar, Long> getService() {
        return avatarService;
    }
}
