package com.nx.forum_project.web.controller.mvc;

import com.nx.forum_project.data.entity.Avatar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(CRUDController.AVATAR_URL_MVC)
public class AvatarController extends CRUDController<Avatar, Long> {

    @Override
    String getEntityName() {
        return CRUDController.AVATAR_NAME;
    }
}
