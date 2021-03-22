package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.HibernateUtil;
import com.nx.forum_project.data.dao.interf.RoleDAO;
import com.nx.forum_project.data.entity.Role;
import org.hibernate.Session;

import java.util.List;

public class HibernateRoleDAO implements RoleDAO {

    @Override
    public void create(Role role) {
        Session session = HibernateUtil.currentSession();
        session.save(role);
    }

    @Override
    public Role findById(Long id) {
        Session session = HibernateUtil.currentSession();
        Role role = session.get(Role.class, id);
        return role;
    }

    @Override
    public List<Role> findAll() {
        Session session = HibernateUtil.currentSession();
        List<Role> roles = (List<Role>) session.createQuery("From Role").list();
        return roles;
    }

    @Override
    public void update(Role role) {
        Session session = HibernateUtil.currentSession();
        session.update(role);
    }

    @Override
    public void delete(Role role) {
        Session session = HibernateUtil.currentSession();
        session.delete(role);
    }
}
