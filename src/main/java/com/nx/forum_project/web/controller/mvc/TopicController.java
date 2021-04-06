package com.nx.forum_project.web.controller.mvc;

import com.nx.forum_project.data.entity.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(CRUDController.TOPIC_URL_MVC)
public class TopicController extends CRUDController<Topic, Long> {

    @Override
    String getEntityName() {
        return CRUDController.TOPIC_NAME;
    }
}