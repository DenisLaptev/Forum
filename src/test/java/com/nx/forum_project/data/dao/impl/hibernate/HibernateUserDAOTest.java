package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.dao.DAOFactory;
import com.nx.forum_project.data.dao.interf.UserDAO;
import com.nx.forum_project.data.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DataJpaTest
public class HibernateUserDAOTest extends DAOTest {

    private final Long USER_ID_FOR_TEST = 1L;
    private final String USER_LOGIN_FOR_TEST = "test";
    private final String USER_LOGIN_FOR_TEST_UPDATED = "testUpdated";

    private final int USER_LIST_SIZE = 10;

    private UserDAO userDAO;

    @BeforeEach
    public void initTest() {

        DAOFactory hibernateFactory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE_REALIZATION_FACTORY);
        userDAO = hibernateFactory.getUserDAO();

    }

    @Test
    public void create() {

        doInTransaction(() -> {

            User user = new User(USER_ID_FOR_TEST, null, null, USER_LOGIN_FOR_TEST, null, null, null, null);

            userDAO.create(user);

            Long createdUserId = user.getId();

            User actualUser = userDAO.findById(createdUserId);

            Long actualUserId = actualUser.getId();
            String actualUserLogin = actualUser.getLogin();

            assertThat(actualUser, notNullValue());
            assertThat(actualUser, isA(User.class));

            assertThat(actualUserId, is(equalTo(createdUserId)));
            assertThat(actualUserLogin, is(equalTo(USER_LOGIN_FOR_TEST)));
        });
    }

    @Test
    public void findById() {

        doInTransaction(() -> {

            User user = new User(USER_ID_FOR_TEST, null, null, USER_LOGIN_FOR_TEST, null, null, null, null);

            userDAO.create(user);

            Long createdUserId = user.getId();

            User actualUser = userDAO.findById(createdUserId);

            Long actualUserId = actualUser.getId();
            String actualUserLogin = actualUser.getLogin();

            assertThat(actualUser, notNullValue());
            assertThat(actualUser, isA(User.class));

            assertThat(actualUserId, is(equalTo(createdUserId)));
            assertThat(actualUserLogin, is(equalTo(USER_LOGIN_FOR_TEST)));
        });
    }

    @Test
    public void findAll() {

        doInTransaction(() -> {

            List<User> actualUserList = new ArrayList<>();
            List<User> expectedUserList = new ArrayList<>();

            int actualUserListSize = 0;
            int expectedUserListSize = USER_LIST_SIZE;

            String testLogin = "";

            for (int i = 1; i <= USER_LIST_SIZE; i++) {

                testLogin = USER_LOGIN_FOR_TEST + i;

                User newUser = new User(USER_ID_FOR_TEST, null, null, testLogin, null, null, null, null);

                userDAO.create(newUser);

                expectedUserList.add(newUser);
            }

            actualUserList = userDAO.findAll();
            actualUserListSize = actualUserList.size();

            assertThat(actualUserListSize, notNullValue());

            assertThat(actualUserListSize, is(equalTo(expectedUserListSize)));
            assertThat(actualUserList, is(equalTo(expectedUserList)));
        });
    }

    @Test
    public void update() {

        doInTransaction(() -> {

            User createdUser = new User(USER_ID_FOR_TEST, null, null, USER_LOGIN_FOR_TEST, null, null, null, null);

            userDAO.create(createdUser);

            Long createdUserId = createdUser.getId();

            User userForUpdate = userDAO.findById(createdUserId);

            userForUpdate.setLogin(USER_LOGIN_FOR_TEST_UPDATED);

            userDAO.update(userForUpdate);

            User userUpdated = userDAO.findById(createdUserId);

            assertThat(userUpdated, notNullValue());
            assertThat(userUpdated, isA(User.class));
            assertThat(userUpdated, is(equalTo(userForUpdate)));
        });
    }

    @Test
    public void delete() {

        doInTransaction(() -> {

            User createdUser = new User(USER_ID_FOR_TEST, null, null, USER_LOGIN_FOR_TEST, null, null, null, null);

            userDAO.create(createdUser);

            Long createdUserId = createdUser.getId();

            User userForDelete = userDAO.findById(createdUserId);

            userDAO.delete(userForDelete);

            User userDeleted = userDAO.findById(createdUserId);

            assertThat(userDeleted, nullValue());
        });
    }
}
