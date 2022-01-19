package com.epam.admissions.office.dao;

import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Result;

import java.util.List;

public interface ResultDao {
    Result getResultById(int id) throws DaoException;

    List<Result> getResultsByScore(double score) throws DaoException;

    List<Result> getResultsBySubjectId(int subjectId) throws DaoException;

    List<Result> getAllResults() throws DaoException;

    int deleteById(int id) throws DaoException;

    int countAllResults() throws DaoException;
}
