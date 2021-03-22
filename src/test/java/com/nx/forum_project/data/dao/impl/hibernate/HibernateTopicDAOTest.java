package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.dao.DAOFactory;
import com.nx.forum_project.data.dao.interf.TopicDAO;
import com.nx.forum_project.data.entity.Topic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DataJpaTest
public class HibernateTopicDAOTest extends DAOTest {

    private final Long TOPIC_ID_FOR_TEST = 1L;
    private final String TOPIC_TITLE_FOR_TEST = "test";
    private final String TOPIC_TITLE_FOR_TEST_UPDATED = "testUpdated";

    private final int TOPIC_LIST_SIZE = 10;

    private TopicDAO topicDAO;

    @BeforeEach
    public void initTest() {

        DAOFactory hibernateFactory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE_REALIZATION_FACTORY);
        topicDAO = hibernateFactory.getTopicDAO();

    }

    @Test
    public void create() {

        doInTransaction(() -> {

            Topic topic = new Topic(TOPIC_ID_FOR_TEST, TOPIC_TITLE_FOR_TEST, null, null, null);

            topicDAO.create(topic);

            Long createdTopicId = topic.getId();

            Topic actualTopic = topicDAO.findById(createdTopicId);

            Long actualTopicId = actualTopic.getId();
            String actualTopicTitle = actualTopic.getTitle();

            assertThat(actualTopic, notNullValue());
            assertThat(actualTopic, isA(Topic.class));

            assertThat(actualTopicId, is(equalTo(createdTopicId)));
            assertThat(actualTopicTitle, is(equalTo(TOPIC_TITLE_FOR_TEST)));
        });
    }

    @Test
    public void findById() {

        doInTransaction(() -> {

            Topic topic = new Topic(TOPIC_ID_FOR_TEST, TOPIC_TITLE_FOR_TEST, null, null, null);

            topicDAO.create(topic);

            Long createdTopicId = topic.getId();

            Topic actualTopic = topicDAO.findById(createdTopicId);

            Long actualTopicId = actualTopic.getId();
            String actualTopicTitle = actualTopic.getTitle();

            assertThat(actualTopic, notNullValue());
            assertThat(actualTopic, isA(Topic.class));

            assertThat(actualTopicId, is(equalTo(createdTopicId)));
            assertThat(actualTopicTitle, is(equalTo(TOPIC_TITLE_FOR_TEST)));
        });
    }

    @Test
    public void findAll() {

        doInTransaction(() -> {

            List<Topic> actualTopicList = new ArrayList<>();
            List<Topic> expectedTopicList = new ArrayList<>();

            int actualTopicListSize = 0;
            int expectedTopicListSize = TOPIC_LIST_SIZE;

            String testTitle = "";

            for (int i = 1; i <= TOPIC_LIST_SIZE; i++) {

                testTitle = TOPIC_TITLE_FOR_TEST + i;

                Topic newTopic = new Topic(TOPIC_ID_FOR_TEST, testTitle, null, null, null);

                topicDAO.create(newTopic);

                expectedTopicList.add(newTopic);
            }

            actualTopicList = topicDAO.findAll();
            actualTopicListSize = actualTopicList.size();

            assertThat(actualTopicListSize, notNullValue());

            assertThat(actualTopicListSize, is(equalTo(expectedTopicListSize)));
            assertThat(actualTopicList, is(equalTo(expectedTopicList)));
        });
    }

    @Test
    public void update() {

        doInTransaction(() -> {

            Topic createdTopic = new Topic(TOPIC_ID_FOR_TEST, TOPIC_TITLE_FOR_TEST, null, null, null);

            topicDAO.create(createdTopic);

            Long createdTopicId = createdTopic.getId();

            Topic topicForUpdate = topicDAO.findById(createdTopicId);

            topicForUpdate.setTitle(TOPIC_TITLE_FOR_TEST_UPDATED);

            topicDAO.update(topicForUpdate);

            Topic topicUpdated = topicDAO.findById(createdTopicId);

            assertThat(topicUpdated, notNullValue());
            assertThat(topicUpdated, isA(Topic.class));
            assertThat(topicUpdated, is(equalTo(topicForUpdate)));
        });
    }

    @Test
    public void delete() {

        doInTransaction(() -> {

            Topic createdTopic = new Topic(TOPIC_ID_FOR_TEST, TOPIC_TITLE_FOR_TEST, null, null, null);

            topicDAO.create(createdTopic);

            Long createdTopicId = createdTopic.getId();

            Topic topicForDelete = topicDAO.findById(createdTopicId);

            topicDAO.delete(topicForDelete);

            Topic topicDeleted = topicDAO.findById(createdTopicId);

            assertThat(topicDeleted, nullValue());
        });
    }
}
