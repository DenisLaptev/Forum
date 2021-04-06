package com.nx.forum_project.web.service.impl.spring_data;

import com.nx.forum_project.data.entity.User;
import com.nx.forum_project.data.spring_data.repository.UserRepository;
import com.nx.forum_project.web.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@Qualifier("UserServiceSpringDataImpl")
public class UserServiceSpringDataImpl extends CRUDSpringDataService<User, Long> implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    CrudRepository<User, Long> getRepository() {
        return userRepository;
    }
}

