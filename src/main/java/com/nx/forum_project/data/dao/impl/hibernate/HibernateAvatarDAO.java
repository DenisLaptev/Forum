package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.HibernateUtil;
import com.nx.forum_project.data.dao.interf.AvatarDAO;
import com.nx.forum_project.data.entity.Avatar;
import org.hibernate.Session;

import java.util.List;

public class HibernateAvatarDAO implements AvatarDAO {

    @Override
    public void create(Avatar avatar) {
        Session session = HibernateUtil.currentSession();
        session.save(avatar);
    }

    @Override
    public Avatar findById(Long id) {
        Session session = HibernateUtil.currentSession();
        Avatar avatar = session.get(Avatar.class, id);
        return avatar;
    }

    @Override
    public List<Avatar> findAll() {
        Session session = HibernateUtil.currentSession();
        List<Avatar> avatars = (List<Avatar>) session.createQuery("From Avatar").list();
        return avatars;
    }

    @Override
    public void update(Avatar avatar) {
        Session session = HibernateUtil.currentSession();
        session.update(avatar);
    }

    @Override
    public void delete(Avatar avatar) {
        Session session = HibernateUtil.currentSession();
        session.delete(avatar);
    }
}
