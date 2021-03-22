package com.nx.forum_project.data.dao.factories;

import com.nx.forum_project.data.dao.DAOFactory;
import com.nx.forum_project.data.dao.impl.hibernate.*;
import com.nx.forum_project.data.dao.interf.*;

public class HibernateDAOFactory extends DAOFactory {

    @Override
    public AvatarDAO getAvatarDAO() {
        return new HibernateAvatarDAO();
    }

    @Override
    public MessageDAO getMessageDAO() {
        return new HibernateMessageDAO();
    }

    @Override
    public RoleDAO getRoleDAO() {
        return new HibernateRoleDAO();
    }

    @Override
    public SectionDAO getSectionDAO() {
        return new HibernateSectionDAO();
    }

    @Override
    public TopicDAO getTopicDAO() {
        return new HibernateTopicDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new HibernateUserDAO();
    }
}
