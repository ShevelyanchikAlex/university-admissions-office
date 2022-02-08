package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.Application;
import com.epam.admissions.office.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;

/**
 * ApplicationService interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface ApplicationService {
    /**
     * Create application
     *
     * @param userId    userId
     * @param facultyId facultyId
     * @return 1 if operation was correctly, otherwise another value
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int createApplication(int userId, int facultyId) throws ServiceException;

    /**
     * Update application
     *
     * @param applicationId applicationId
     * @param facultyId     facultyId
     * @return 1 if operation was correctly, otherwise another value
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    boolean updateFacultyIdOfApplication(int applicationId, int facultyId) throws ServiceException;

    /**
     * Update confirm status of application
     *
     * @param applicationId   applicationId
     * @param status          status
     * @param rejectionReason rejectionReason
     * @return 1 if operation was correctly, otherwise another value
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    boolean updateConfirmStatusOfApplication(int applicationId, boolean status, String rejectionReason) throws ServiceException;

    /**
     * Get application by id
     *
     * @param id id
     * @return application if operation was correctly, otherwise null
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    Application getApplicationById(int id) throws ServiceException;

    /**
     * Get application by userId
     *
     * @param userId userId
     * @return application if operation was correctly, otherwise null
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    Application getApplicationByUserId(int userId) throws ServiceException;

    /**
     * Get list of all application
     *
     * @return list of all applications
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<Application> getAllApplications() throws ServiceException;

    /**
     * Get list of confirmed application
     *
     * @return list of confirmed applications
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<Application> getAllConfirmedApplications() throws ServiceException;

    /**
     * Get list of not confirmed applications
     *
     * @return list of not confirmed applications
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<Application> getAllNotConfirmedApplications() throws ServiceException;

    /**
     * Get list of applications by faculty id
     *
     * @param facultyId facultyId
     * @return list of applications by faculty id
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<Application> getApplicationsByFacultyId(int facultyId) throws ServiceException;

    /**
     * Get list of applications by apply date
     *
     * @param applyDate applyDate
     * @return list of applications by apply date
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<Application> getApplicationsByApplyDate(Date applyDate) throws ServiceException;

    /**
     * Get list of applications by decisionDate
     *
     * @param decisionDate decisionDate
     * @return list of applications by decisionDate
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<Application> getApplicationsByDecisionDate(Date decisionDate) throws ServiceException;

    /**
     * Delete Application by id
     *
     * @param id applicationId
     * @return 1 if operation was correctly, otherwise another value
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int deleteById(int id) throws ServiceException;

    /**
     * Count all applications
     *
     * @return count of all applications
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int countAllApplication() throws ServiceException;

    /**
     * Count all responded applications
     *
     * @return count of all responded applications
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int countAllRespondedApplication() throws ServiceException;
}
