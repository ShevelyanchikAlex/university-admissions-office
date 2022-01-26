package com.epam.admissions.office.dao;


import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Application;

import java.sql.Date;
import java.util.List;

public interface ApplicationDao {
    int createApplication(Application application) throws DaoException;

    Application getApplicationById(int id) throws DaoException;

    Application getApplicationByUserId(int userId) throws DaoException;

    List<Application> getAllApplications() throws DaoException;

    List<Application> getApplicationsByFacultyId(int facultyId) throws DaoException;

    List<Application> getApplicationsByApplyDate(Date applyDate) throws DaoException;

    List<Application> getApplicationsByDecisionDate(Date decisionDate) throws DaoException;

    int deleteById(int id) throws DaoException;

    int countAllApplication() throws DaoException;
}
