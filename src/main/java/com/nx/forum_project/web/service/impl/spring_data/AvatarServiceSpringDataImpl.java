package com.nx.forum_project.web.service.impl.spring_data;

import com.nx.forum_project.data.entity.Avatar;
import com.nx.forum_project.data.spring_data.repository.AvatarRepository;
import com.nx.forum_project.web.service.interf.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AvatarServiceSpringDataImpl")
public class AvatarServiceSpringDataImpl extends CRUDSpringDataService<Avatar, Long> implements AvatarService {

    @Autowired
    AvatarRepository avatarRepository;

    @Override
    CrudRepository<Avatar, Long> getRepository() {
        return avatarRepository;
    }
}
