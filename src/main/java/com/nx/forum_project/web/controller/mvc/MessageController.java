package com.nx.forum_project.web.controller.mvc;

import com.nx.forum_project.data.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(CRUDController.MESSAGE_URL_MVC)
public class MessageController extends CRUDController<Message, Long> {

    @Override
    String getEntityName() {
        return CRUDController.MESSAGE_NAME;
    }
}