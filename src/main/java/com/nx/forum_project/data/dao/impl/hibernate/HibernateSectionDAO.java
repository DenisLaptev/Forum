package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.HibernateUtil;
import com.nx.forum_project.data.dao.interf.SectionDAO;
import com.nx.forum_project.data.entity.Section;
import org.hibernate.Session;

import java.util.List;

public class HibernateSectionDAO implements SectionDAO {

    @Override
    public void create(Section section) {
        Session session = HibernateUtil.currentSession();
        session.save(section);
    }

    @Override
    public Section findById(Long id) {
        Session session = HibernateUtil.currentSession();
        Section section = session.get(Section.class, id);
        return section;
    }

    @Override
    public List<Section> findAll() {
        Session session = HibernateUtil.currentSession();
        List<Section> sections = (List<Section>) session.createQuery("From Section").list();
        return sections;
    }

    @Override
    public void update(Section section) {
        Session session = HibernateUtil.currentSession();
        session.update(section);
    }

    @Override
    public void delete(Section section) {
        Session session = HibernateUtil.currentSession();
        session.delete(section);
    }
}
