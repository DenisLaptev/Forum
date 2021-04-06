package com.nx.forum_project.web.service.impl.dao.hibernate;

import com.nx.forum_project.data.dao.interf.CRUDDAO;
import com.nx.forum_project.data.entity.Topic;
import com.nx.forum_project.web.service.interf.TopicService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("TopicServiceHibernateImpl")
public class TopicServiceHibernateImpl extends CRUDDAOHibernateService<Topic, Long> implements TopicService {

    @Override
    public CRUDDAO<Topic, Long> getCRUDDAO() {
        return getDAOFactory().getTopicDAO();
    }
}
