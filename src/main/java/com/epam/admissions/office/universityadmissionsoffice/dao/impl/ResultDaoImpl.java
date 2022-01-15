package com.epam.admissions.office.universityadmissionsoffice.dao.impl;

import com.epam.admissions.office.universityadmissionsoffice.dao.DaoException;
import com.epam.admissions.office.universityadmissionsoffice.dao.ResultDao;
import com.epam.admissions.office.universityadmissionsoffice.entity.Result;

import java.util.List;
import java.util.Optional;

public class ResultDaoImpl implements ResultDao {
    @Override
    public int create(Result result) throws DaoException {
        return 0;
    }

    @Override
    public int update(int id) throws DaoException {
        return 0;
    }

    @Override
    public int delete(int id) throws DaoException {
        return 0;
    }

    @Override
    public Optional<Result> getResultById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Result> getResultByCertificateId(int certificateId) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Result> getResultByApplicationId(int applicationId) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Result> getResultsList() throws DaoException {
        return null;
    }
}
