package com.nx.forum_project.data.dao.impl.hibernate;

import com.nx.forum_project.data.dao.DAOFactory;
import com.nx.forum_project.data.dao.interf.AvatarDAO;
import com.nx.forum_project.data.dao.interf.RoleDAO;
import com.nx.forum_project.data.entity.Avatar;
import com.nx.forum_project.data.entity.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DataJpaTest
public class HibernateRoleDAOTest extends DAOTest {

    private final Long ROLE_ID_FOR_TEST = 1L;
    private final String ROLE_ROLE_FOR_TEST = "test";
    private final String ROLE_ROLE_FOR_TEST_UPDATED = "testUpdated";

    private final int ROLE_LIST_SIZE = 10;

    private RoleDAO roleDAO;

    @BeforeEach
    public void initTest() {

        DAOFactory hibernateFactory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE_REALIZATION_FACTORY);
        roleDAO = hibernateFactory.getRoleDAO();

    }

    @Test
    public void create() {

        doInTransaction(() -> {

            Role role = new Role(ROLE_ID_FOR_TEST, ROLE_ROLE_FOR_TEST, null);

            roleDAO.create(role);

            Long createdRoleId = role.getId();

            Role actualRole = roleDAO.findById(createdRoleId);

            Long actualRoleId = actualRole.getId();
            String actualRoleRole = actualRole.getRole();

            assertThat(actualRole, notNullValue());
            assertThat(actualRole, isA(Role.class));

            assertThat(actualRoleId, is(equalTo(createdRoleId)));
            assertThat(actualRoleRole, is(equalTo(ROLE_ROLE_FOR_TEST)));
        });
    }

    @Test
    public void findById() {

        doInTransaction(() -> {

            Role role = new Role(ROLE_ID_FOR_TEST, ROLE_ROLE_FOR_TEST, null);

            roleDAO.create(role);

            Long createdRoleId = role.getId();

            Role actualRole = roleDAO.findById(createdRoleId);

            Long actualRoleId = actualRole.getId();
            String actualRoleRole = actualRole.getRole();

            assertThat(actualRole, notNullValue());
            assertThat(actualRole, isA(Role.class));

            assertThat(actualRoleId, is(equalTo(createdRoleId)));
            assertThat(actualRoleRole, is(equalTo(ROLE_ROLE_FOR_TEST)));
        });
    }

    @Test
    public void findAll() {

        doInTransaction(() -> {

            List<Role> actualRoleList = new ArrayList<>();
            List<Role> expectedRoleList = new ArrayList<>();

            int actualRoleListSize = 0;
            int expectedRoleListSize = ROLE_LIST_SIZE;

            String testRole = "";

            for (int i = 1; i <= ROLE_LIST_SIZE; i++) {

                testRole = ROLE_ROLE_FOR_TEST + i;

                Role newRole = new Role(ROLE_ID_FOR_TEST, testRole, null);

                roleDAO.create(newRole);

                expectedRoleList.add(newRole);
            }

            actualRoleList = roleDAO.findAll();
            actualRoleListSize = actualRoleList.size();

            assertThat(actualRoleListSize, notNullValue());

            assertThat(actualRoleListSize, is(equalTo(expectedRoleListSize)));
            assertThat(actualRoleList, is(equalTo(expectedRoleList)));
        });
    }

    @Test
    public void update() {

        doInTransaction(() -> {

            Role createdRole = new Role(ROLE_ID_FOR_TEST, ROLE_ROLE_FOR_TEST, null);

            roleDAO.create(createdRole);

            Long createdRoleId = createdRole.getId();

            Role roleForUpdate = roleDAO.findById(createdRoleId);

            roleForUpdate.setRole(ROLE_ROLE_FOR_TEST_UPDATED);

            roleDAO.update(roleForUpdate);

            Role roleUpdated = roleDAO.findById(createdRoleId);

            assertThat(roleUpdated, notNullValue());
            assertThat(roleUpdated, isA(Role.class));
            assertThat(roleUpdated, is(equalTo(roleForUpdate)));
        });
    }

    @Test
    public void delete() {

        doInTransaction(() -> {

            Role createdRole = new Role(ROLE_ID_FOR_TEST, ROLE_ROLE_FOR_TEST, null);

            roleDAO.create(createdRole);

            Long createdRoleId = createdRole.getId();

            Role roleForDelete = roleDAO.findById(createdRoleId);

            roleDAO.delete(roleForDelete);

            Role roleDeleted = roleDAO.findById(createdRoleId);

            assertThat(roleDeleted, nullValue());
        });
    }
}
