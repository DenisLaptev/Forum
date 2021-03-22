package com.nx.forum_project.data.dao;

import com.nx.forum_project.data.dao.factories.HibernateDAOFactory;
import com.nx.forum_project.data.dao.interf.*;

public abstract class DAOFactory {

    public static final int HIBERNATE_REALIZATION_FACTORY = 1;

    public abstract AvatarDAO getAvatarDAO();

    public abstract MessageDAO getMessageDAO();

    public abstract RoleDAO getRoleDAO();

    public abstract SectionDAO getSectionDAO();

    public abstract TopicDAO getTopicDAO();

    public abstract UserDAO getUserDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {

        switch (whichFactory) {
            case HIBERNATE_REALIZATION_FACTORY:
                return new HibernateDAOFactory();

            default:
                throw new UnsupportedOperationException();
        }
    }
}
