package com.epam.admissions.office.universityadmissionsoffice.dao;



import com.epam.admissions.office.universityadmissionsoffice.entity.Result;

import java.util.List;
import java.util.Optional;

public interface ResultDao {
    int create(Result result) throws DaoException;

    int update(int id) throws DaoException;

    int delete(int id) throws DaoException;

    Optional<Result> getResultById(int id) throws DaoException;

    Optional<Result> getResultByCertificateId(int certificateId) throws DaoException;

    Optional<Result> getResultByApplicationId(int applicationId) throws DaoException;

    List<Result> getResultsList() throws DaoException;
}
