package com.nx.forum_project.data.spring_data.repository;

import com.nx.forum_project.data.entity.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Long> {
}

