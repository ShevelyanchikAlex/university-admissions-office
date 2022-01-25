package com.epam.admissions.office.dao.impl;

import com.epam.admissions.office.dao.ApplicationDao;
import com.epam.admissions.office.dao.constant.DBRequest;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.dao.mapper.RowMapperFactory;
import com.epam.admissions.office.dao.queryoperator.QueryOperator;
import com.epam.admissions.office.dao.queryoperator.impl.QueryOperatorImpl;
import com.epam.admissions.office.entity.Application;

import java.sql.Date;
import java.util.List;

public class ApplicationDaoImpl implements ApplicationDao {
    private final QueryOperator<Application> queryOperator;

    public ApplicationDaoImpl() {
        RowMapper<Application> mapper = RowMapperFactory.getApplicationRowMapper();
        this.queryOperator = new QueryOperatorImpl<>(mapper);
    }

    @Override
    public Application getApplicationById(int id) throws DaoException {
        return queryOperator.executeSingleEntityQuery(DBRequest.GET_APPLICATION_BY_ID_QUERY, id);
    }

    @Override
    public Application getApplicationByUserId(int userId) throws DaoException {
        return queryOperator.executeSingleEntityQuery(DBRequest.GET_APPLICATION_BY_USER_ID_QUERY, userId);
    }

    @Override
    public List<Application> getAllApplications() throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_ALL_APPLICATIONS_QUERY);
    }

    @Override
    public List<Application> getApplicationsByFacultyId(int facultyId) throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_APPLICATIONS_BY_FACULTY_ID_QUERY, facultyId);
    }

    @Override
    public List<Application> getApplicationsByApplyDate(Date applyDate) throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_APPLICATIONS_BY_APPLY_DATE_QUERY, applyDate);
    }

    @Override
    public List<Application> getApplicationsByDecisionDate(Date decisionDate) throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_APPLICATIONS_BY_DECISION_DATE_QUERY, decisionDate.toString());
    }

    @Override
    public int deleteById(int id) throws DaoException {
        return queryOperator.executeUpdate(DBRequest.DELETE_APPLICATION_QUERY, id);
    }

    @Override
    public int countAllApplication() throws DaoException {
        return queryOperator.executeCountQuery(DBRequest.COUNT_ALL_APPLICATIONS_QUERY);
    }
}