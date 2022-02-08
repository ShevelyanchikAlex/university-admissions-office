package com.epam.admissions.office.dao;


import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Application;

import java.sql.Date;
import java.util.List;

/**
 * ApplicationDao interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface ApplicationDao {
    /**
     * Create application
     *
     * @param application application
     * @return 1 if operation was correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int createApplication(Application application) throws DaoException;

    /**
     * Update application
     *
     * @param application application
     * @return 1 if operation was correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int updateApplication(Application application) throws DaoException;

    /**
     * Get application by id
     *
     * @param id id
     * @return application if operation was correctly, otherwise null
     * @throws DaoException if an exception is thrown while working with db
     */
    Application getApplicationById(int id) throws DaoException;

    /**
     * Get application by userId
     *
     * @param userId userId
     * @return application if operation was correctly, otherwise null
     * @throws DaoException if an exception is thrown while working with db
     */
    Application getApplicationByUserId(int userId) throws DaoException;

    /**
     * Get list of all application
     *
     * @return list of all applications
     * @throws DaoException if an exception is thrown while working with db
     */
    List<Application> getAllApplications() throws DaoException;

    /**
     * Get list of confirmed application
     *
     * @return list of confirmed applications
     * @throws DaoException if an exception is thrown while working with db
     */
    List<Application> getAllConfirmedApplications() throws DaoException;

    /**
     * Get list of not confirmed applications
     *
     * @return list of not confirmed applications
     * @throws DaoException if an exception is thrown while working with db
     */
    List<Application> getAllNotConfirmedApplications() throws DaoException;

    /**
     * Get list of applications by faculty id
     *
     * @param facultyId facultyId
     * @return list of applications by faculty id
     * @throws DaoException if an exception is thrown while working with db
     */
    List<Application> getApplicationsByFacultyId(int facultyId) throws DaoException;

    /**
     * Get list of applications by apply date
     *
     * @param applyDate applyDate
     * @return list of applications by apply date
     * @throws DaoException if an exception is thrown while working with db
     */
    List<Application> getApplicationsByApplyDate(Date applyDate) throws DaoException;

    /**
     * Get list of applications by decisionDate
     *
     * @param decisionDate decisionDate
     * @return list of applications by decisionDate
     * @throws DaoException if an exception is thrown while working with db
     */
    List<Application> getApplicationsByDecisionDate(Date decisionDate) throws DaoException;

    /**
     * Delete Application by id
     *
     * @param id applicationId
     * @return 1 if operation was correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int deleteById(int id) throws DaoException;

    /**
     * Count all applications
     *
     * @return count of all applications
     * @throws DaoException if an exception is thrown while working with db
     */
    int countAllApplication() throws DaoException;

    /**
     * Count all responded applications
     *
     * @return count of all responded applications
     * @throws DaoException if an exception is thrown while working with db
     */
    int countAllRespondedApplication() throws DaoException;
}
