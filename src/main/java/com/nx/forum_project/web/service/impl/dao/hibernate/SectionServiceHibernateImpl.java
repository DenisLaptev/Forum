package com.nx.forum_project.web.service.impl.dao.hibernate;

import com.nx.forum_project.data.dao.interf.CRUDDAO;
import com.nx.forum_project.data.entity.Section;
import com.nx.forum_project.web.service.interf.SectionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("SectionServiceHibernateImpl")
public class SectionServiceHibernateImpl extends CRUDDAOHibernateService<Section, Long> implements SectionService {

    @Override
    public CRUDDAO<Section, Long> getCRUDDAO() {
        return getDAOFactory().getSectionDAO();
    }
}
