package com.epam.admissions.office.dao.impl;

import com.epam.admissions.office.dao.FacultyDao;
import com.epam.admissions.office.dao.constant.DBRequest;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.dao.mapper.RowMapperFactory;
import com.epam.admissions.office.dao.queryoperator.QueryOperator;
import com.epam.admissions.office.dao.queryoperator.impl.QueryOperatorImpl;
import com.epam.admissions.office.entity.faculty.Faculty;

import java.util.List;

/**
 * FacultyDaoImpl class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class FacultyDaoImpl implements FacultyDao {
    private final QueryOperator<Faculty> queryOperator;

    public FacultyDaoImpl() {
        RowMapper<Faculty> mapper = RowMapperFactory.getFacultyRowMapper();
        this.queryOperator = new QueryOperatorImpl<>(mapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Faculty getFacultyById(int id) throws DaoException {
        return queryOperator.executeSingleEntityQuery(DBRequest.GET_FACULTY_BY_ID_QUERY, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Faculty> getAllFaculties() throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_ALL_FACULTIES_QUERY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteById(int id) throws DaoException {
        return queryOperator.executeUpdate(DBRequest.DELETE_FACULTY_QUERY, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countAllFaculties() throws DaoException {
        return queryOperator.executeCountQuery(DBRequest.COUNT_ALL_FACULTIES_QUERY);
    }
}
