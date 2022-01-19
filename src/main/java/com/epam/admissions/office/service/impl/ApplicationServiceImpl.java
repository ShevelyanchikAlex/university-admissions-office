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
    public Application getApplicationById(int id) throws ServiceException {
        try {
            ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();
            return applicationDao.getApplicationById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Application getApplicationByUserId(int userId) throws ServiceException {
        try {
            ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();
            return applicationDao.getApplicationByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Application> getAllApplications() throws ServiceException {
        try {
            ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();
            return applicationDao.getAllApplications();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Application> getApplicationsByFacultyId(int facultyId) throws ServiceException {
        try {
            ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();
            return applicationDao.getApplicationsByFacultyId(facultyId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Application> getApplicationsByApplyDate(Date applyDate) throws ServiceException {
        //TODO Validation
        try {
            ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();
            return applicationDao.getApplicationsByApplyDate(applyDate);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Application> getApplicationsByDecisionDate(Date decisionDate) throws ServiceException {
        //TODO Validation
        try {
            ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();
            return applicationDao.getApplicationsByDecisionDate(decisionDate);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int deleteById(int id) throws ServiceException {
        try {
            ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();
            return applicationDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int countAllApplication() throws ServiceException {
        try {
            ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();
            return applicationDao.countAllApplication();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
