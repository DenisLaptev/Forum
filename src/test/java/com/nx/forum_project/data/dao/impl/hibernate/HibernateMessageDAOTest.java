package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.dao.DAOFactory;
import com.nx.forum_project.data.dao.interf.AvatarDAO;
import com.nx.forum_project.data.dao.interf.MessageDAO;
import com.nx.forum_project.data.entity.Avatar;
import com.nx.forum_project.data.entity.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DataJpaTest
public class HibernateMessageDAOTest extends DAOTest {

    private final Long MESSAGE_ID_FOR_TEST = 1L;
    private final String MESSAGE_TEXT_FOR_TEST = "test";
    private final String MESSAGE_TEXT_FOR_TEST_UPDATED = "testUpdated";

    private final int MESSAGE_LIST_SIZE = 10;

    private MessageDAO messageDAO;

    @BeforeEach
    public void initTest() {

        DAOFactory hibernateFactory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE_REALIZATION_FACTORY);
        messageDAO = hibernateFactory.getMessageDAO();

    }

    @Test
    public void create() {

        doInTransaction(() -> {

            Message message = new Message(MESSAGE_ID_FOR_TEST, MESSAGE_TEXT_FOR_TEST, null, null, null);

            messageDAO.create(message);

            Long createdMessageId = message.getId();

            Message actualMessage = messageDAO.findById(createdMessageId);

            Long actualMessageId = actualMessage.getId();
            String actualMessageText = actualMessage.getText();

            assertThat(actualMessage, notNullValue());
            assertThat(actualMessage, isA(Message.class));

            assertThat(actualMessageId, is(equalTo(createdMessageId)));
            assertThat(actualMessageText, is(equalTo(MESSAGE_TEXT_FOR_TEST)));
        });
    }

    @Test
    public void findById() {

        doInTransaction(() -> {

            Message message = new Message(MESSAGE_ID_FOR_TEST, MESSAGE_TEXT_FOR_TEST, null, null, null);

            messageDAO.create(message);

            Long createdMessageId = message.getId();

            Message actualMessage = messageDAO.findById(createdMessageId);

            Long actualMessageId = actualMessage.getId();
            String actualMessageText = actualMessage.getText();

            assertThat(actualMessage, notNullValue());
            assertThat(actualMessage, isA(Message.class));

            assertThat(actualMessageId, is(equalTo(createdMessageId)));
            assertThat(actualMessageText, is(equalTo(MESSAGE_TEXT_FOR_TEST)));
        });
    }

    @Test
    public void findAll() {

        doInTransaction(() -> {

            List<Message> actualMessageList = new ArrayList<>();
            List<Message> expectedMessageList = new ArrayList<>();

            int actualMessageListSize = 0;
            int expectedMessageListSize = MESSAGE_LIST_SIZE;

            String testText = "";

            for (int i = 1; i <= MESSAGE_LIST_SIZE; i++) {

                testText = MESSAGE_TEXT_FOR_TEST + i;

                Message newMessage = new Message(MESSAGE_ID_FOR_TEST, testText, null, null, null);

                messageDAO.create(newMessage);

                expectedMessageList.add(newMessage);
            }

            actualMessageList = messageDAO.findAll();
            actualMessageListSize = actualMessageList.size();

            assertThat(actualMessageListSize, notNullValue());

            assertThat(actualMessageListSize, is(equalTo(expectedMessageListSize)));
            assertThat(actualMessageList, is(equalTo(expectedMessageList)));
        });
    }

    @Test
    public void update() {

        doInTransaction(() -> {

            Message createdMessage = new Message(MESSAGE_ID_FOR_TEST, MESSAGE_TEXT_FOR_TEST, null, null, null);

            messageDAO.create(createdMessage);

            Long createdMessageId = createdMessage.getId();

            Message messageForUpdate = messageDAO.findById(createdMessageId);

            messageForUpdate.setText(MESSAGE_TEXT_FOR_TEST_UPDATED);

            messageDAO.update(messageForUpdate);

            Message messageUpdated = messageDAO.findById(createdMessageId);

            assertThat(messageUpdated, notNullValue());
            assertThat(messageUpdated, isA(Message.class));
            assertThat(messageUpdated, is(equalTo(messageForUpdate)));
        });
    }

    @Test
    public void delete() {

        doInTransaction(() -> {

            Message createdMessage = new Message(MESSAGE_ID_FOR_TEST, MESSAGE_TEXT_FOR_TEST, null, null, null);

            messageDAO.create(createdMessage);

            Long createdMessageId = createdMessage.getId();

            Message messageForDelete = messageDAO.findById(createdMessageId);

            messageDAO.delete(messageForDelete);

            Message messageDeleted = messageDAO.findById(createdMessageId);

            assertThat(messageDeleted, nullValue());
        });
    }
}
