package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.ResultDao;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Result;
import com.epam.admissions.office.service.ResultService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public class ResultServiceImpl implements ResultService {
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
