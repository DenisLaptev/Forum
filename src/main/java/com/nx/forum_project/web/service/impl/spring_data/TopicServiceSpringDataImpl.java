package com.nx.forum_project.web.service.impl.spring_data;

import com.nx.forum_project.data.entity.Topic;
import com.nx.forum_project.data.spring_data.repository.TopicRepository;
import com.nx.forum_project.web.service.interf.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@Qualifier("TopicServiceSpringDataImpl")
public class TopicServiceSpringDataImpl extends CRUDSpringDataService<Topic, Long> implements TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Override
    CrudRepository<Topic, Long> getRepository() {
        return topicRepository;
    }
}

