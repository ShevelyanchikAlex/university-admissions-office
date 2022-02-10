package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.ResultDao;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Result;
import com.epam.admissions.office.service.ResultService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

/**
 * ResultServiceImpl class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class ResultServiceImpl implements ResultService {
    private static final int SUCCESSFUL_OPERATION = 1;
    private static final int DEFAULT_RESULT_ID = 0;
    private static final int DEFAULT_CERTIFICATE_ID = 0;
    private static final boolean DEFAULT_IS_CERTIFICATE_CONFIRMED = true;

    private final ResultDao resultDao = DaoFactory.getInstance().getResultDao();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean createResult(double score, int applicationId, int subjectId) throws ServiceException {
        Result result = new Result(DEFAULT_RESULT_ID, score, DEFAULT_CERTIFICATE_ID, null,
                DEFAULT_IS_CERTIFICATE_CONFIRMED, applicationId, subjectId);

        try {
            return resultDao.createResult(result) == SUCCESSFUL_OPERATION;
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean updateResult(int resultId, double score, int subjectId) throws ServiceException {
        try {
            Result result = resultDao.getResultById(resultId);
            result.setScore(score);
            result.setSubjectId(subjectId);
            return resultDao.updateResult(result) == SUCCESSFUL_OPERATION;
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Result getResultById(int id) throws ServiceException {
        try {
            return resultDao.getResultById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Result> getResultsByScore(double score) throws ServiceException {
        try {
            return resultDao.getResultsByScore(score);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Result> getResultsByApplicationId(int applicationId) throws ServiceException {
        try {
            return resultDao.getResultsByApplicationId(applicationId);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Result> getResultsBySubjectId(int subjectId) throws ServiceException {
        try {
            return resultDao.getResultsBySubjectId(subjectId);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Result> getAllResults() throws ServiceException {
        try {
            return resultDao.getAllResults();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteById(int id) throws ServiceException {
        try {
            return resultDao.deleteById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countAllResults() throws ServiceException {
        try {
            return resultDao.countAllResults();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }
}
