package com.nx.forum_project.data;

import com.nx.forum_project.data.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static Session currentSession() throws HibernateException {

        sessionFactory = getSessionFactory();
        Session session = (Session) threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory != null) {
                session = sessionFactory.openSession();
                threadLocal.set(session);
            }
        }

        return session;
    }

    public static void closeCurrentSession() throws HibernateException {

        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration();
                configuration.configure("hibernate-h2.cfg.xml");
                //configuration.configure("hibernate-postgres.cfg.xml");

                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
                registryBuilder.applySettings(configuration.getProperties());

                registry = registryBuilder.build();

                MetadataSources sources = new MetadataSources(registry);

                sources.addAnnotatedClass(Avatar.class);
                sources.addAnnotatedClass(Message.class);
                sources.addAnnotatedClass(Role.class);
                sources.addAnnotatedClass(Section.class);
                sources.addAnnotatedClass(Topic.class);
                sources.addAnnotatedClass(User.class);

                Metadata metadata = sources.getMetadataBuilder().build();

                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void destroyFactory() {

        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
            sessionFactory = null;
        }
    }

}

