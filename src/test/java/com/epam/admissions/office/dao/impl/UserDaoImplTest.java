package com.epam.admissions.office.dao.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.UserDao;
import com.epam.admissions.office.dao.connection.ConnectionPool;
import com.epam.admissions.office.dao.connection.exception.ConnectionPoolException;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;
import com.epam.admissions.office.service.exception.ServiceException;
import com.epam.admissions.office.service.util.UtilFactory;
import com.epam.admissions.office.service.util.digest.PasswordDigest;
import org.junit.jupiter.api.*;

import java.util.List;

class UserDaoImplTest {
    private static final int SUCCESSFUL_OPERATION = 1;

    private UserDao userDao;
    private PasswordDigest passwordDigest;

    @BeforeAll
    static void initConnectionPool() throws ConnectionPoolException {
        ConnectionPool.getInstance().initPoolData();
    }

    @BeforeEach
    void setUp() {
        userDao = DaoFactory.getInstance().getUserDao();
        this.passwordDigest = UtilFactory.getInstance().getPasswordDigest();
    }

    @AfterAll
    static void disposeConnectionPool() {
        ConnectionPool.getInstance().dispose();
    }

    @Test
    void createUser() throws DaoException, ServiceException {
        User user = new User(0, "Alex", "Shevelyanchik", passwordDigest.getDigestPassword("qweSDFvbn123"), "shevelyanchik_02@mail.ru", "AB5534433", false, UserRole.USER_WITHOUT_APPLICATION);
        int result = userDao.createUser(user);
        Assertions.assertEquals(SUCCESSFUL_OPERATION, result);
    }


    @Test
    void getUserById() throws DaoException {
        int id = 14;
        User user = userDao.getUserById(id);
        Assertions.assertNotNull(user);
    }

    @Test
    void getByEmail() throws DaoException {
        User user = userDao.getByEmail("shevelyanchik_02@mail.ru");
        Assertions.assertNotNull(user);
    }

    @Test
    void getByUserRole() throws DaoException {
        User user = userDao.getByUserRole(UserRole.USER);
        Assertions.assertNotNull(user);
    }

    @Test
    void getAllUsers() throws DaoException {
        List<User> userList = userDao.getAllUsers();
        Assertions.assertNotNull(userList);
    }

    @Test
    void getAllApplicants() throws DaoException {
        List<User> applicants = userDao.getAllApplicants();
        Assertions.assertNotNull(applicants);
    }

    @Test
    void getAllAdministrators() throws DaoException {
        List<User> administrators = userDao.getAllAdministrators();
        Assertions.assertNotNull(administrators);
    }

    @Test
    void getUsersByRoleId() throws DaoException {
        List<User> users = userDao.getUsersByRoleId(UserRole.USER.ordinal());
        Assertions.assertNotNull(users);
    }


    @Test
    void countAllUsers() throws DaoException {
        int expected = 3;
        int count = userDao.countAllUsers();
        Assertions.assertEquals(expected, count);
    }

    @Test
    void countByUserRole() throws DaoException {
        int expected = 1;
        int count = userDao.countByUserRole(UserRole.ADMIN);
        Assertions.assertEquals(expected, count);
    }
}