package com.nx.forum_project.web.controller.rest;

import com.nx.forum_project.web.service.interf.CRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public abstract class CRUDRestController<E, K> {

    public static final String AVATAR_URL = "avatar";
    public static final String MESSAGE_URL = "message";
    public static final String ROLE_URL = "role";
    public static final String SECTION_URL = "section";
    public static final String TOPIC_URL = "topic";
    public static final String USER_URL = "user";

    abstract CRUDService<E, K> getService();

    @PostMapping
    public ResponseEntity<E> create(@RequestBody E entity) {

        getService().create(entity);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> findById(@PathVariable K id) {

        E leaf = getService().findById(id);

        if (leaf == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(leaf);
    }

    @GetMapping
    public ResponseEntity<List<E>> findAll() {

        List<E> leafs = getService().findAll();
        return ResponseEntity.ok(leafs);
    }

    @PutMapping
    public ResponseEntity<E> update(@RequestBody E entity){

        E updatedEntity = getService().update(entity);
        return ResponseEntity.ok(updatedEntity);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable K id) throws Exception {

        E entityForDelete = getService().findById(id);
        getService().delete(entityForDelete);
        return ResponseEntity.noContent().build();
    }

}
