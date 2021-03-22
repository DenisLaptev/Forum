package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.HibernateUtil;
import com.nx.forum_project.data.dao.interf.UserDAO;
import com.nx.forum_project.data.entity.User;
import org.hibernate.Session;

import java.util.List;

public class HibernateUserDAO implements UserDAO {

    @Override
    public void create(User user) {
        Session session = HibernateUtil.currentSession();
        session.save(user);
    }

    @Override
    public User findById(Long id) {
        Session session = HibernateUtil.currentSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public List<User> findAll() {
        Session session = HibernateUtil.currentSession();
        List<User> users = (List<User>) session.createQuery("From User").list();
        return users;
    }

    @Override
    public void update(User user) {
        Session session = HibernateUtil.currentSession();
        session.update(user);
    }

    @Override
    public void delete(User user) {
        Session session = HibernateUtil.currentSession();
        session.delete(user);
    }
}
