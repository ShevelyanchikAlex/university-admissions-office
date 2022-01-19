package com.epam.admissions.office.dao;

import com.epam.admissions.office.dao.impl.*;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private static final ApplicationDao applicationDao = new MySqlApplicationDaoImpl();
    private static final UserDao userDao = new MySqlUserDaoImpl();
    private static final ResultDao resultDao = new MySqlResultDaoImpl();
    private static final SubjectDao subjectDao = new MySqlSubjectDaoImpl();
    private static final FacultyDao facultyDao = new MySqlFacultyDaoImpl();
    private static final FacultyAdmissionInfoDao facultyAdmissionInfoDao = new MySqlFacultyAdmissionInfoImpl();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public ApplicationDao getApplicationDao() {
        return applicationDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public ResultDao getResultDao() {
        return resultDao;
    }

    public SubjectDao getSubjectDao() {
        return subjectDao;
    }

    public FacultyDao getFacultyDao() {
        return facultyDao;
    }

    public FacultyAdmissionInfoDao getFacultyAdmissionInfoDao() {
        return facultyAdmissionInfoDao;
    }
}
