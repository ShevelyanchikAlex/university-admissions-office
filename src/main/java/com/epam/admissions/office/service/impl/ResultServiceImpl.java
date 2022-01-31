package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.ResultDao;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Result;
import com.epam.admissions.office.service.ResultService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public class ResultServiceImpl implements ResultService {
    private final int SUCCESSFUL_OPERATION = 1;

    @Override
    public boolean createResult(double score, int applicationId, int subjectId) throws ServiceException {
        final int DEFAULT_RESULT_ID = 0;
        final int DEFAULT_CERTIFICATE_ID = 0;
        final boolean DEFAULT_IS_CERTIFICATE_CONFIRMED = true;
        ResultDao resultDao = DaoFactory.getInstance().getResultDao();

        Result result = new Result(DEFAULT_RESULT_ID, score, DEFAULT_CERTIFICATE_ID, null,
                DEFAULT_IS_CERTIFICATE_CONFIRMED, applicationId, subjectId);

        try {
            return resultDao.createResult(result) == SUCCESSFUL_OPERATION;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateResult(int resultId, double score, int subjectId) throws ServiceException {
        ResultDao resultDao = DaoFactory.getInstance().getResultDao();

        try {
            Result result = resultDao.getResultById(resultId);
            result.setScore(score);
            result.setSubjectId(subjectId);

            return resultDao.updateResult(result) == SUCCESSFUL_OPERATION;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Result getResultById(int id) throws ServiceException {
        ResultDao resultDao = DaoFactory.getInstance().getResultDao();

        try {
            return resultDao.getResultById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Result> getResultsByScore(double score) throws ServiceException {
        ResultDao resultDao = DaoFactory.getInstance().getResultDao();

        try {
            return resultDao.getResultsByScore(score);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Result> getResultsByApplicationId(int applicationId) throws ServiceException {
        ResultDao resultDao = DaoFactory.getInstance().getResultDao();

        try {
            return resultDao.getResultsByApplicationId(applicationId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Result> getResultsBySubjectId(int subjectId) throws ServiceException {
        ResultDao resultDao = DaoFactory.getInstance().getResultDao();

        try {
            return resultDao.getResultsBySubjectId(subjectId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Result> getAllResults() throws ServiceException {
        ResultDao resultDao = DaoFactory.getInstance().getResultDao();

        try {
            return resultDao.getAllResults();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int deleteById(int id) throws ServiceException {
        ResultDao resultDao = DaoFactory.getInstance().getResultDao();

        try {
            return resultDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int countAllResults() throws ServiceException {
        ResultDao resultDao = DaoFactory.getInstance().getResultDao();

        try {
            return resultDao.countAllResults();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
