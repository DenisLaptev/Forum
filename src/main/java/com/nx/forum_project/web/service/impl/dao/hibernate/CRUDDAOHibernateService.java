package com.nx.forum_project.web.service.impl.dao.hibernate;

import com.nx.forum_project.data.dao.DAOFactory;
import com.nx.forum_project.web.service.impl.dao.CRUDDAOService;

public abstract class CRUDDAOHibernateService<E, K> extends CRUDDAOService<E, K> {

    @Override
    public DAOFactory getDAOFactory() {
        DAOFactory hibernateFactory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE_REALIZATION_FACTORY);
        return hibernateFactory;
    }
}
