package com.nx.forum_project.web.service.impl.dao.hibernate;

import com.nx.forum_project.data.dao.interf.CRUDDAO;
import com.nx.forum_project.data.entity.Avatar;
import com.nx.forum_project.web.service.interf.AvatarService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AvatarServiceHibernateImpl")
public class AvatarServiceHibernateImpl extends CRUDDAOHibernateService<Avatar, Long> implements AvatarService {

    @Override
    public CRUDDAO<Avatar, Long> getCRUDDAO() {
        return getDAOFactory().getAvatarDAO();
    }
}
