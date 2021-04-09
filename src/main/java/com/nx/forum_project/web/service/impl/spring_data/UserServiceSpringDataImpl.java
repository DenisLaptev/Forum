package com.nx.forum_project.web.service.impl.spring_data;

import com.nx.forum_project.data.entity.User;
import com.nx.forum_project.data.spring_data.repository.UserRepository;
import com.nx.forum_project.web.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Qualifier("UserServiceSpringDataImpl")
public class UserServiceSpringDataImpl extends CRUDSpringDataService<User, Long> implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    CrudRepository<User, Long> getRepository() {
        return userRepository;
    }

    //overrode method to encode the password of user at first and then save to DB
    @Override
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        getRepository().save(user);
    }
}

