package com.epam.admissions.office.dao.impl;

import com.epam.admissions.office.dao.SubjectDao;
import com.epam.admissions.office.dao.constant.DBRequest;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.dao.mapper.RowMapperFactory;
import com.epam.admissions.office.dao.queryoperator.QueryOperator;
import com.epam.admissions.office.dao.queryoperator.impl.QueryOperatorImpl;
import com.epam.admissions.office.entity.Subject;

import java.util.List;

/**
 * SubjectDaoImpl class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class SubjectDaoImpl implements SubjectDao {
    private final QueryOperator<Subject> queryOperator;

    public SubjectDaoImpl() {
        RowMapper<Subject> mapper = RowMapperFactory.getSubjectRowMapper();
        this.queryOperator = new QueryOperatorImpl<>(mapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Subject getSubjectById(int id) throws DaoException {
        return queryOperator.executeSingleEntityQuery(DBRequest.GET_SUBJECT_BY_ID_QUERY, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Subject> getAllSubjects() throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_ALL_SUBJECTS_QUERY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteById(int id) throws DaoException {
        return queryOperator.executeUpdate(DBRequest.DELETE_SUBJECT_QUERY, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countAllSubjects() throws DaoException {
        return queryOperator.executeCountQuery(DBRequest.COUNT_ALL_SUBJECTS_QUERY);
    }
}
