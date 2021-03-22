package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.HibernateUtil;
import com.nx.forum_project.data.dao.interf.TopicDAO;
import com.nx.forum_project.data.entity.Topic;
import org.hibernate.Session;

import java.util.List;

public class HibernateTopicDAO implements TopicDAO {

    @Override
    public void create(Topic topic) {
        Session session = HibernateUtil.currentSession();
        session.save(topic);
    }

    @Override
    public Topic findById(Long id) {
        Session session = HibernateUtil.currentSession();
        Topic topic = session.get(Topic.class, id);
        return topic;
    }

    @Override
    public List<Topic> findAll() {
        Session session = HibernateUtil.currentSession();
        List<Topic> topics = (List<Topic>) session.createQuery("From Topic").list();
        return topics;
    }

    @Override
    public void update(Topic topic) {
        Session session = HibernateUtil.currentSession();
        session.update(topic);
    }

    @Override
    public void delete(Topic topic) {
        Session session = HibernateUtil.currentSession();
        session.delete(topic);
    }
}
