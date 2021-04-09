package com.nx.forum_project.data.spring_data.repository;

import com.nx.forum_project.data.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);

}
