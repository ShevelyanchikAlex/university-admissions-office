package com.epam.admissions.office.dao.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.FacultyDao;
import com.epam.admissions.office.dao.UserDao;
import com.epam.admissions.office.dao.connection.ConnectionPool;
import com.epam.admissions.office.dao.connection.exception.ConnectionPoolException;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.Faculty;
import com.epam.admissions.office.service.util.UtilFactory;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FacultyDaoImplTest {
    private FacultyDao facultyDao;

    @BeforeAll
    static void initConnectionPool() throws ConnectionPoolException {
        ConnectionPool.getInstance().initPoolData();
    }

    @BeforeEach
    void setUp() {
        facultyDao = DaoFactory.getInstance().getFacultyDao();
    }

    @AfterAll
    static void disposeConnectionPool() {
        ConnectionPool.getInstance().dispose();
    }

    @Test
    void getFacultyById() throws DaoException {
        int id = 1;
        Faculty faculty = facultyDao.getFacultyById(id);
        Assertions.assertNotNull(faculty);
    }

    @Test
    void getAllFaculties() throws DaoException {
        List<Faculty> facultyList = facultyDao.getAllFaculties();
        Assertions.assertNotNull(facultyList);
    }

    @Test
    void countAllFaculties() throws DaoException {
        int expected = 3;
        int count = facultyDao.countAllFaculties();
        Assertions.assertEquals(expected, count);
    }
}