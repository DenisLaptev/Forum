package com.nx.forum_project.data.spring_data.repository;

import com.nx.forum_project.data.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
