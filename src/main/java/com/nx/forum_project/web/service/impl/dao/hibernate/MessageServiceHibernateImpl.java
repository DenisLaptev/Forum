package com.nx.forum_project.web.service.impl.dao.hibernate;

import com.nx.forum_project.data.dao.interf.CRUDDAO;
import com.nx.forum_project.data.entity.Message;
import com.nx.forum_project.web.service.interf.MessageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("MessageServiceHibernateImpl")
public class MessageServiceHibernateImpl extends CRUDDAOHibernateService<Message, Long> implements MessageService {

    @Override
    public CRUDDAO<Message, Long> getCRUDDAO() {
        return getDAOFactory().getMessageDAO();
    }
}
