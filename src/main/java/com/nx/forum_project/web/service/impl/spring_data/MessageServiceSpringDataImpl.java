package com.nx.forum_project.web.service.impl.spring_data;

import com.nx.forum_project.data.entity.Message;
import com.nx.forum_project.data.spring_data.repository.MessageRepository;
import com.nx.forum_project.web.service.interf.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@Qualifier("MessageServiceSpringDataImpl")
public class MessageServiceSpringDataImpl extends CRUDSpringDataService<Message, Long> implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    CrudRepository<Message, Long> getRepository() {
        return messageRepository;
    }
}
