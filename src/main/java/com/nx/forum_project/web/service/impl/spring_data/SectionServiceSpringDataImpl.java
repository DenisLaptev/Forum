package com.nx.forum_project.web.service.impl.spring_data;

import com.nx.forum_project.data.entity.Section;
import com.nx.forum_project.data.spring_data.repository.SectionRepository;
import com.nx.forum_project.web.service.interf.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@Qualifier("SectionServiceSpringDataImpl")
public class SectionServiceSpringDataImpl extends CRUDSpringDataService<Section, Long> implements SectionService {

    @Autowired
    SectionRepository sectionRepository;

    @Override
    CrudRepository<Section, Long> getRepository() {
        return sectionRepository;
    }
}
