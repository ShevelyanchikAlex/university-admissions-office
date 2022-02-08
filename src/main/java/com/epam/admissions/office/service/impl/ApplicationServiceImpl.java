package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.ApplicationDao;
import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Application;
import com.epam.admissions.office.service.ApplicationService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;

/**
 * ApplicationServiceImpl class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class ApplicationServiceImpl implements ApplicationService {
    private static final int SUCCESSFUL_OPERATION = 1;
    private static final int DEFAULT_APPLICATION_ID = 0;
    private static final boolean DEFAULT_IS_APPROVED = false;

    /**
     * {@inheritDoc}
     */
    @Override
    public Application getApplicationById(int id) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.getApplicationById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Application getApplicationByUserId(int userId) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.getApplicationByUserId(userId);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Application> getAllApplications() throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.getAllApplications();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Application> getAllConfirmedApplications() throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.getAllConfirmedApplications();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Application> getAllNotConfirmedApplications() throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.getAllNotConfirmedApplications();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Application> getApplicationsByFacultyId(int facultyId) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.getApplicationsByFacultyId(facultyId);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int createApplication(int userId, int facultyId) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        Application application = new Application(DEFAULT_APPLICATION_ID, new Date(System.currentTimeMillis()),
                DEFAULT_IS_APPROVED, null, null, userId, facultyId);

        try {
            return applicationDao.createApplication(application);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean updateFacultyIdOfApplication(int applicationId, int facultyId) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            Application application = applicationDao.getApplicationById(applicationId);
            application.setFacultyId(facultyId);
            return applicationDao.updateApplication(application) == SUCCESSFUL_OPERATION;
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean updateConfirmStatusOfApplication(int applicationId, boolean status, String rejectionReason) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            Application application = applicationDao.getApplicationById(applicationId);
            application.setApproved(status);
            application.setRejectionReason(rejectionReason);
            application.setDecisionDate(new Date(System.currentTimeMillis()));
            return applicationDao.updateApplication(application) == SUCCESSFUL_OPERATION;
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Application> getApplicationsByApplyDate(Date applyDate) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.getApplicationsByApplyDate(applyDate);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Application> getApplicationsByDecisionDate(Date decisionDate) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.getApplicationsByDecisionDate(decisionDate);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteById(int id) throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.deleteById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countAllApplication() throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.countAllApplication();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countAllRespondedApplication() throws ServiceException {
        ApplicationDao applicationDao = DaoFactory.getInstance().getApplicationDao();

        try {
            return applicationDao.countAllRespondedApplication();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }
}
