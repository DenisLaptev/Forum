package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.HibernateUtil;
import com.nx.forum_project.data.dao.interf.MessageDAO;
import com.nx.forum_project.data.entity.Message;
import org.hibernate.Session;

import java.util.List;

public class HibernateMessageDAO implements MessageDAO {

    @Override
    public void create(Message message) {
        Session session = HibernateUtil.currentSession();
        session.save(message);
    }

    @Override
    public Message findById(Long id) {
        Session session = HibernateUtil.currentSession();
        Message message = session.get(Message.class, id);
        return message;
    }

    @Override
    public List<Message> findAll() {
        Session session = HibernateUtil.currentSession();
        List<Message> messages = (List<Message>) session.createQuery("From Message").list();
        return messages;
    }

    @Override
    public void update(Message message) {
        Session session = HibernateUtil.currentSession();
        session.update(message);
    }

    @Override
    public void delete(Message message) {
        Session session = HibernateUtil.currentSession();
        session.delete(message);
    }
}
