package com.nx.forum_project.web.service.impl.spring_data;

import com.nx.forum_project.web.service.interf.CRUDService;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class CRUDSpringDataService<E, K> implements CRUDService<E, K> {

    abstract CrudRepository<E, K> getRepository();

    @Override
    public void create(E entity) {
        getRepository().save(entity);
    }

    @Override
    public E findById(K id) {
        return (E) getRepository().findById(id).orElse(null);
    }

    @Override
    public List<E> findAll() {
        List<E> entities = new ArrayList<>();
        getRepository().findAll().forEach(entities::add);
        return entities;
    }

    @Override
    public E update(E entity) {
        getRepository().save(entity);
        return entity;
    }

    @Override
    public void delete(E entity) {
        getRepository().delete(entity);
    }

}
