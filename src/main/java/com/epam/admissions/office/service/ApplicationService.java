package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.Application;
import com.epam.admissions.office.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;

public interface ApplicationService {
    Application getApplicationById(int id) throws ServiceException;

    Application getApplicationByUserId(int userId) throws ServiceException;

    List<Application> getAllApplications() throws ServiceException;

    List<Application> getApplicationsByFacultyId(int facultyId) throws ServiceException;

    List<Application> getApplicationsByApplyDate(Date applyDate) throws ServiceException;

    List<Application> getApplicationsByDecisionDate(Date decisionDate) throws ServiceException;

    int deleteById(int id) throws ServiceException;

    int countAllApplication() throws ServiceException;
}
