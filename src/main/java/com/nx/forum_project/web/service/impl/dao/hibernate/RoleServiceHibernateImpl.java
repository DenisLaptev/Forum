package com.nx.forum_project.web.service.impl.dao.hibernate;

import com.nx.forum_project.data.dao.interf.CRUDDAO;
import com.nx.forum_project.data.entity.Role;
import com.nx.forum_project.web.service.interf.RoleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("RoleServiceHibernateImpl")
public class RoleServiceHibernateImpl extends CRUDDAOHibernateService<Role, Long> implements RoleService {

    @Override
    public CRUDDAO<Role, Long> getCRUDDAO() {
        return getDAOFactory().getRoleDAO();
    }
}
