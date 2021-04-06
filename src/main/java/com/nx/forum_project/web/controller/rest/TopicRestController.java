package com.nx.forum_project.web.controller.rest;

import com.nx.forum_project.data.entity.Topic;
import com.nx.forum_project.web.service.interf.CRUDService;
import com.nx.forum_project.web.service.interf.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CRUDRestController.TOPIC_URL)
public class TopicRestController extends CRUDRestController<Topic, Long> {

    @Autowired
    @Qualifier("TopicServiceSpringDataImpl")
    private TopicService topicService;

    @Override
    CRUDService<Topic, Long> getService() {
        return topicService;
    }
}
