package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.ApplicationDao;
import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Application;
import com.epam.admissions.office.service.ApplicationService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;

public class ApplicationServiceImpl implements ApplicationService {
    @Override
    public boolean createApplication(String faculty, int userId, int facultyId, double firstSubjectPoints, double secondSubjectPoints, double thirdSubjectPoints) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        Application application = new Application(0, new Date(System.currentTimeMillis()),
                false, null, null, userId, facultyId, firstSubjectPoints, secondSubjectPoints, thirdSubjectPoints);

        try {
            return applicationDao.createApplication(application) == 1;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Application getApplicationById(int id) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.getApplicationById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Application getApplicationByUserId(int userId) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.getApplicationByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Application> getAllApplications() throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.getAllApplications();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Application> getApplicationsByFacultyId(int facultyId) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.getApplicationsByFacultyId(facultyId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Application> getApplicationsByApplyDate(Date applyDate) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        //TODO Validation
        try {
            return applicationDao.getApplicationsByApplyDate(applyDate);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Application> getApplicationsByDecisionDate(Date decisionDate) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        //TODO Validation
        try {
            return applicationDao.getApplicationsByDecisionDate(decisionDate);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int deleteById(int id) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int countAllApplication() throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.countAllApplication();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
