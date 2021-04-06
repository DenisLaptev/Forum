package com.nx.forum_project.web.service.impl.dao;

import com.nx.forum_project.data.dao.DAOFactory;
import com.nx.forum_project.data.dao.interf.CRUDDAO;
import com.nx.forum_project.web.service.interf.CRUDService;

import java.util.List;

public abstract class CRUDDAOService<E, K> implements CRUDService<E, K> {

    public abstract DAOFactory getDAOFactory();

    public abstract CRUDDAO<E, K> getCRUDDAO();

    @Override
    public void create(E entity) {

        getCRUDDAO().create(entity);
    }

    @Override
    public E findById(K id) {

        return getCRUDDAO().findById(id);
    }

    @Override
    public List<E> findAll() {

        return getCRUDDAO().findAll();
    }

    @Override
    public E update(E entity) {
        getCRUDDAO().update(entity);
        return entity;
    }

    @Override
    public void delete(E entity) {
        getCRUDDAO().delete(entity);
    }

}
