package com.nx.forum_project.web.service.impl.spring_data;

import com.nx.forum_project.data.entity.Role;
import com.nx.forum_project.data.spring_data.repository.RoleRepository;
import com.nx.forum_project.web.service.interf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@Qualifier("RoleServiceSpringDataImpl")
public class RoleServiceSpringDataImpl extends CRUDSpringDataService<Role, Long> implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    CrudRepository<Role, Long> getRepository() {
        return roleRepository;
    }
}
