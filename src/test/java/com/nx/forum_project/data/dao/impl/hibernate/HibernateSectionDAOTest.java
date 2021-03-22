package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.dao.DAOFactory;
import com.nx.forum_project.data.dao.interf.AvatarDAO;
import com.nx.forum_project.data.dao.interf.SectionDAO;
import com.nx.forum_project.data.entity.Avatar;
import com.nx.forum_project.data.entity.Section;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DataJpaTest
public class HibernateSectionDAOTest extends DAOTest {

    private final Long SECTION_ID_FOR_TEST = 1L;
    private final String SECTION_TITLE_FOR_TEST = "test";
    private final String SECTION_TITLE_FOR_TEST_UPDATED = "testUpdated";

    private final int SECTION_LIST_SIZE = 10;

    private SectionDAO sectionDAO;

    @BeforeEach
    public void initTest() {

        DAOFactory hibernateFactory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE_REALIZATION_FACTORY);
        sectionDAO = hibernateFactory.getSectionDAO();

    }

    @Test
    public void create() {

        doInTransaction(() -> {

            Section section = new Section(SECTION_ID_FOR_TEST, SECTION_TITLE_FOR_TEST, null, null);

            sectionDAO.create(section);

            Long createdSectionId = section.getId();

            Section actualSection = sectionDAO.findById(createdSectionId);

            Long actualSectionId = actualSection.getId();
            String actualSectionTitle = actualSection.getTitle();

            assertThat(actualSection, notNullValue());
            assertThat(actualSection, isA(Section.class));

            assertThat(actualSectionId, is(equalTo(createdSectionId)));
            assertThat(actualSectionTitle, is(equalTo(SECTION_TITLE_FOR_TEST)));
        });
    }

    @Test
    public void findById() {

        doInTransaction(() -> {

            Section section = new Section(SECTION_ID_FOR_TEST, SECTION_TITLE_FOR_TEST, null, null);

            sectionDAO.create(section);

            Long createdSectionId = section.getId();

            Section actualSection = sectionDAO.findById(createdSectionId);

            Long actualSectionId = actualSection.getId();
            String actualSectionTitle = actualSection.getTitle();

            assertThat(actualSection, notNullValue());
            assertThat(actualSection, isA(Section.class));

            assertThat(actualSectionId, is(equalTo(createdSectionId)));
            assertThat(actualSectionTitle, is(equalTo(SECTION_TITLE_FOR_TEST)));
        });
    }

    @Test
    public void findAll() {

        doInTransaction(() -> {

            List<Section> actualSectionList = new ArrayList<>();
            List<Section> expectedSectionList = new ArrayList<>();

            int actualSectionListSize = 0;
            int expectedSectionListSize = SECTION_LIST_SIZE;

            String testTitle = "";

            for (int i = 1; i <= SECTION_LIST_SIZE; i++) {

                testTitle = SECTION_TITLE_FOR_TEST + i;

                Section newSection = new Section(SECTION_ID_FOR_TEST, testTitle, null,null);

                sectionDAO.create(newSection);

                expectedSectionList.add(newSection);
            }

            actualSectionList = sectionDAO.findAll();
            actualSectionListSize = actualSectionList.size();

            assertThat(actualSectionListSize, notNullValue());

            assertThat(actualSectionListSize, is(equalTo(expectedSectionListSize)));
            assertThat(actualSectionList, is(equalTo(expectedSectionList)));
        });
    }

    @Test
    public void update() {

        doInTransaction(() -> {

            Section createdSection = new Section(SECTION_ID_FOR_TEST, SECTION_TITLE_FOR_TEST, null, null);

            sectionDAO.create(createdSection);

            Long createdSectionId = createdSection.getId();

            Section sectionForUpdate = sectionDAO.findById(createdSectionId);

            sectionForUpdate.setTitle(SECTION_TITLE_FOR_TEST_UPDATED);

            sectionDAO.update(sectionForUpdate);

            Section sectionUpdated = sectionDAO.findById(createdSectionId);

            assertThat(sectionUpdated, notNullValue());
            assertThat(sectionUpdated, isA(Section.class));
            assertThat(sectionUpdated, is(equalTo(sectionForUpdate)));
        });
    }

    @Test
    public void delete() {

        doInTransaction(() -> {

            Section createdSection = new Section(SECTION_ID_FOR_TEST, SECTION_TITLE_FOR_TEST, null, null);

            sectionDAO.create(createdSection);

            Long createdSectionId = createdSection.getId();

            Section sectionForDelete = sectionDAO.findById(createdSectionId);

            sectionDAO.delete(sectionForDelete);

            Section sectionDeleted = sectionDAO.findById(createdSectionId);

            assertThat(sectionDeleted, nullValue());
        });
    }
}
