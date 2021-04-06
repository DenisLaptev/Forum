package com.nx.forum_project.web.controller.rest;

import com.nx.forum_project.data.entity.Section;
import com.nx.forum_project.web.service.interf.CRUDService;
import com.nx.forum_project.web.service.interf.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CRUDRestController.SECTION_URL)
public class SectionRestController extends CRUDRestController<Section, Long> {

    @Autowired
    @Qualifier("SectionServiceSpringDataImpl")
    private SectionService sectionService;

    @Override
    CRUDService<Section, Long> getService() {
        return sectionService;
    }
}