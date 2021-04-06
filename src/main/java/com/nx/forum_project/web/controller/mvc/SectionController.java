package com.nx.forum_project.web.controller.mvc;

import com.nx.forum_project.data.entity.Section;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(CRUDController.SECTION_URL_MVC)
public class SectionController extends CRUDController<Section, Long> {

    @Override
    String getEntityName() {
        return CRUDController.SECTION_NAME;
    }
}