package com.kot.user.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.kot.user.builder.UserEntityBuilder;
import com.kot.user.entity.UserEntity;

@SpringBootTest
@Transactional
public class UserDaoIntegrationTest {

    @Autowired
    private UserDao userDao;

    private final UserEntityBuilder userEntityBuilder = new UserEntityBuilder();

    @Test
    void testCreateAndFindById() {
        UserEntity user = userEntityBuilder.buildNew();

        UserEntity savedUser = userDao.create(user);
        assertNotNull(savedUser.getId());

        UserEntity retrievedUser = userDao.findById(savedUser.getId().toString());
        assertEquals(savedUser.getId(), retrievedUser.getId());
    }

    @Test
    void testUpdate() {
        UserEntity user = userEntityBuilder.buildNew();

        UserEntity savedUser = userDao.create(user);
        assertNotNull(savedUser.getId());

        savedUser.setFirstName("NewUpdatedName");
        userDao.update(savedUser, savedUser.getId().toString());

        UserEntity retrievedUser = userDao.findById(savedUser.getId().toString());
        assertEquals(savedUser.getFirstName(), retrievedUser.getFirstName());
    }

    @Test
    void testFindAll() {
        UserEntity user1 = userEntityBuilder.buildNew();
        userDao.create(user1);

        UserEntity user2 = userEntityBuilder.buildNew();
        userDao.create(user2);

        List<UserEntity> users = userDao.findAll().toList();
        assertEquals(2, users.size());
    }

    @Test
    void testFindByFirstNameEqual() {
        userDao.create(userEntityBuilder.setFirstName("someOne").buildNew());
        userDao.create(userEntityBuilder.setFirstName("someOne").buildNew());
        userDao.create(userEntityBuilder.setFirstName("someOneDifferent").buildNew());

        String specification = "firstName=someOne";

        List<UserEntity> users = userDao.findAll(specification);
        assertEquals(2, users.size());
    }

    @Test
    void testFindByFirstNameContain() {
        userDao.create(userEntityBuilder.setFirstName("someOne").buildNew());
        userDao.create(userEntityBuilder.setFirstName("someOne").buildNew());
        userDao.create(userEntityBuilder.setFirstName("someOneDifferent").buildNew());

        String specification = "firstName:someOne";

        List<UserEntity> users = userDao.findAll(specification);
        assertEquals(3, users.size());
    }

    @Test
    void testFindByLastNameEqual() {
        userDao.create(userEntityBuilder.setLastName("someOne").buildNew());
        userDao.create(userEntityBuilder.setLastName("someOne").buildNew());
        userDao.create(userEntityBuilder.setLastName("someOneDifferent").buildNew());

        String specification = "lastName=someOne";

        List<UserEntity> users = userDao.findAll(specification);
        assertEquals(2, users.size());
    }

    @Test
    void testFindByLastNameContain() {
        userDao.create(userEntityBuilder.setLastName("someOne").buildNew());
        userDao.create(userEntityBuilder.setLastName("someOne").buildNew());
        userDao.create(userEntityBuilder.setLastName("someOneDifferent").buildNew());

        String specification = "lastName:someOne";

        List<UserEntity> users = userDao.findAll(specification);
        assertEquals(3, users.size());
    }

    @Test
    void testFindByFullNameEqual() {
        userDao.create(userEntityBuilder.setFirstName("someOne").buildNew());
        userDao.create(userEntityBuilder.setLastName("someOne").buildNew());
        userDao.create(userEntityBuilder.setFirstName("someOneDifferent").buildNew());

        String specification = "fullName=someOne";

        List<UserEntity> users = userDao.findAll(specification);
        assertEquals(2, users.size());
    }

    @Test
    void testFindByFullNameContain() {
        userDao.create(userEntityBuilder.setFirstName("someOne").buildNew());
        userDao.create(userEntityBuilder.setLastName("someOne").buildNew());
        userDao.create(userEntityBuilder.setLastName("someOneDifferent").buildNew());
        userDao.create(userEntityBuilder.setLastName("different").buildNew());

        String specification = "fullName:someOne";

        List<UserEntity> users = userDao.findAll(specification);
        assertEquals(3, users.size());
    }

    @Test
    void testFindByFullNameContainPaging() {
        userDao.create(userEntityBuilder.setFirstName("someOne").buildNew());
        userDao.create(userEntityBuilder.setLastName("someOne").buildNew());
        userDao.create(userEntityBuilder.setLastName("someOneDifferent").buildNew());
        userDao.create(userEntityBuilder.setLastName("different").buildNew());

        String specification = "fullName:someOne";

        List<UserEntity> users = userDao.findAll(specification, Pageable.unpaged()).toList();
        assertEquals(3, users.size());
    }

    @Test
    void testFindAllPage() {
        userDao.create(userEntityBuilder.buildNew());
        userDao.create(userEntityBuilder.buildNew());
        userDao.create(userEntityBuilder.buildNew());

        Page<UserEntity> usersPage = userDao.findAll(Pageable.unpaged());
        assertEquals(3, usersPage.getTotalElements());
        assertEquals(1, usersPage.getTotalPages());
    }

    @Test
    void testFindAllPaging() {
        for (int i = 0; i < 16; i++) {
            userDao.create(userEntityBuilder.buildNew());
        }
        Page<UserEntity> usersPage = userDao.findAll(PageRequest.of(0, 15));
        assertEquals(16, usersPage.getTotalElements());
        assertEquals(2, usersPage.getTotalPages());
        assertEquals(15, usersPage.toList().size());
    }

}
