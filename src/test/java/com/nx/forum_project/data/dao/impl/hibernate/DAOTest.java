package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.HibernateUtil;
import com.nx.forum_project.data.TransactionCallback;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAOTest {

    public void doInTransaction(TransactionCallback tc) {

        Session session = HibernateUtil.currentSession();
        Transaction transaction = session.beginTransaction();
        try {
            tc.doInTransaction();
            transaction.rollback();
        } catch (Exception e) {

        } finally {
            session.close();
        }
    }
}
