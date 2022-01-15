package com.epam.admissions.office.universityadmissionsoffice.dao;


import com.epam.admissions.office.universityadmissionsoffice.dao.impl.*;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private static final ApplicationDao applicationDao = new ApplicationDaoImpl();
    private static final UserDao userDao = new UserDaoImpl();
    private static final ResultDao resultDao = new ResultDaoImpl();
    private static final SubjectDao subjectDao = new SubjectDaoImpl();
    private static final FacultyDao facultyDao = new FacultyDaoImpl();
    private static final FacultyAdmissionInfoDao facultyAdmissionInfoDao = new FacultyAdmissionInfoImpl();

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
