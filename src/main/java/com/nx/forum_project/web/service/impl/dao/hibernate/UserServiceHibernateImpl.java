package com.nx.forum_project.web.service.impl.dao.hibernate;

import com.nx.forum_project.data.dao.interf.CRUDDAO;
import com.nx.forum_project.data.entity.User;
import com.nx.forum_project.web.service.interf.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("UserServiceHibernateImpl")
public class UserServiceHibernateImpl extends CRUDDAOHibernateService<User, Long> implements UserService {

    @Override
    public CRUDDAO<User, Long> getCRUDDAO() {
        return getDAOFactory().getUserDAO();
    }
}
