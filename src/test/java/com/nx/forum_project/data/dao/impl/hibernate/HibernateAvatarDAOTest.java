package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.dao.DAOFactory;
import com.nx.forum_project.data.dao.interf.AvatarDAO;
import com.nx.forum_project.data.entity.Avatar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DataJpaTest
public class HibernateAvatarDAOTest extends DAOTest {

    private final Long AVATAR_ID_FOR_TEST = 1L;
    private final String AVATAR_URL_FOR_TEST = "test";
    private final String AVATAR_URL_FOR_TEST_UPDATED = "testUpdated";

    private final int AVATAR_LIST_SIZE = 10;

    private AvatarDAO avatarDAO;

    @BeforeEach
    public void initTest() {

        DAOFactory hibernateFactory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE_REALIZATION_FACTORY);
        avatarDAO = hibernateFactory.getAvatarDAO();

    }

    @Test
    public void create() {

        doInTransaction(() -> {

            Avatar avatar = new Avatar(AVATAR_ID_FOR_TEST, AVATAR_URL_FOR_TEST, null);

            avatarDAO.create(avatar);

            Long createdAvatarId = avatar.getId();

            Avatar actualAvatar = avatarDAO.findById(createdAvatarId);

            Long actualAvatarId = actualAvatar.getId();
            String actualAvatarUrl = actualAvatar.getUrl();

            assertThat(actualAvatar, notNullValue());
            assertThat(actualAvatar, isA(Avatar.class));

            assertThat(actualAvatarId, is(equalTo(createdAvatarId)));
            assertThat(actualAvatarUrl, is(equalTo(AVATAR_URL_FOR_TEST)));
        });
    }

    @Test
    public void findById() {

        doInTransaction(() -> {

            Avatar avatar = new Avatar(AVATAR_ID_FOR_TEST, AVATAR_URL_FOR_TEST, null);

            avatarDAO.create(avatar);

            Long createdAvatarId = avatar.getId();

            Avatar actualAvatar = avatarDAO.findById(createdAvatarId);

            Long actualAvatarId = actualAvatar.getId();
            String actualAvatarUrl = actualAvatar.getUrl();

            assertThat(actualAvatar, notNullValue());
            assertThat(actualAvatar, isA(Avatar.class));

            assertThat(actualAvatarId, is(equalTo(createdAvatarId)));
            assertThat(actualAvatarUrl, is(equalTo(AVATAR_URL_FOR_TEST)));
        });
    }

    @Test
    public void findAll() {

        doInTransaction(() -> {

            List<Avatar> actualAvatarList = new ArrayList<>();
            List<Avatar> expectedAvatarList = new ArrayList<>();

            int actualAvatarListSize = 0;
            int expectedAvatarListSize = AVATAR_LIST_SIZE;

            String testUrl = "";

            for (int i = 1; i <= AVATAR_LIST_SIZE; i++) {

                testUrl = AVATAR_URL_FOR_TEST + i;

                Avatar newAvatar = new Avatar(AVATAR_ID_FOR_TEST, testUrl, null);

                avatarDAO.create(newAvatar);

                expectedAvatarList.add(newAvatar);
            }

            actualAvatarList = avatarDAO.findAll();
            actualAvatarListSize = actualAvatarList.size();

            assertThat(actualAvatarListSize, notNullValue());

            assertThat(actualAvatarListSize, is(equalTo(expectedAvatarListSize)));
            assertThat(actualAvatarList, is(equalTo(expectedAvatarList)));
        });
    }

    @Test
    public void update() {

        doInTransaction(() -> {

            Avatar createdAvatar = new Avatar(AVATAR_ID_FOR_TEST, AVATAR_URL_FOR_TEST, null);

            avatarDAO.create(createdAvatar);

            Long createdAvatarId = createdAvatar.getId();

            Avatar avatarForUpdate = avatarDAO.findById(createdAvatarId);

            avatarForUpdate.setUrl(AVATAR_URL_FOR_TEST_UPDATED);

            avatarDAO.update(avatarForUpdate);

            Avatar avatarUpdated = avatarDAO.findById(createdAvatarId);

            assertThat(avatarUpdated, notNullValue());
            assertThat(avatarUpdated, isA(Avatar.class));
            assertThat(avatarUpdated, is(equalTo(avatarForUpdate)));
        });
    }

    @Test
    public void delete() {

        doInTransaction(() -> {

            Avatar createdAvatar = new Avatar(AVATAR_ID_FOR_TEST, AVATAR_URL_FOR_TEST, null);

            avatarDAO.create(createdAvatar);

            Long createdAvatarId = createdAvatar.getId();

            Avatar avatarForDelete = avatarDAO.findById(createdAvatarId);

            avatarDAO.delete(avatarForDelete);

            Avatar avatarDeleted = avatarDAO.findById(createdAvatarId);

            assertThat(avatarDeleted, nullValue());
        });
    }
}
