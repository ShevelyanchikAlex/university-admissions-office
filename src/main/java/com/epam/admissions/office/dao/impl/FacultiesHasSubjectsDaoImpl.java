package com.epam.admissions.office.dao.impl;

import com.epam.admissions.office.dao.FacultiesHasSubjectsDao;
import com.epam.admissions.office.dao.constant.DBRequest;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.dao.mapper.RowMapperFactory;
import com.epam.admissions.office.dao.queryoperator.QueryOperator;
import com.epam.admissions.office.dao.queryoperator.impl.QueryOperatorImpl;
import com.epam.admissions.office.entity.faculty.FacultyHasSubject;

import java.util.List;

/**
 * FacultiesHasSubjectsDaoImpl class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class FacultiesHasSubjectsDaoImpl implements FacultiesHasSubjectsDao {
    private final QueryOperator<FacultyHasSubject> queryOperator;

    public FacultiesHasSubjectsDaoImpl() {
        RowMapper<FacultyHasSubject> mapper = RowMapperFactory.getFacultiesHasSubjectsRowMapper();
        this.queryOperator = new QueryOperatorImpl<>(mapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FacultyHasSubject> getSubjectsIdOfFacultyById(int facultyId) throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_SUBJECTS_ID_OF_FACULTY_QUERY, facultyId);
    }
}
