package com.epam.admissions.office.dao.impl;

import com.epam.admissions.office.dao.ResultDao;
import com.epam.admissions.office.dao.constant.DBRequest;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.dao.mapper.RowMapperFactory;
import com.epam.admissions.office.dao.queryoperator.QueryOperator;
import com.epam.admissions.office.dao.queryoperator.impl.QueryOperatorImpl;
import com.epam.admissions.office.entity.Result;

import java.util.List;

public class MySqlResultDaoImpl implements ResultDao {
    private final QueryOperator<Result> queryOperator;

    public MySqlResultDaoImpl() {
        RowMapper<Result> mapper = RowMapperFactory.getResultRowMapper();
        this.queryOperator = new QueryOperatorImpl<>(mapper);
    }

    @Override
    public Result getResultById(int id) throws DaoException {
        return queryOperator.executeSingleEntityQuery(DBRequest.GET_RESULT_BY_ID_QUERY, id);
    }

    @Override
    public List<Result> getResultsByScore(double score) throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_RESULTS_BY_SCORE_QUERY, score);
    }

    @Override
    public List<Result> getResultsBySubjectId(int subjectId) throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_RESULTS_BY_SUBJECT_ID_QUERY, subjectId);
    }

    @Override
    public List<Result> getAllResults() throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_ALL_RESULTS_QUERY);
    }

    @Override
    public int deleteById(int id) throws DaoException {
        return queryOperator.executeUpdate(DBRequest.DELETE_RESULT_QUERY, id);
    }

    @Override
    public int countAllResults() throws DaoException {
        return queryOperator.executeCountQuery(DBRequest.COUNT_ALL_RESULTS_QUERY);
    }
}
