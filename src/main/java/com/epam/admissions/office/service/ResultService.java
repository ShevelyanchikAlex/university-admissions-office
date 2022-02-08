package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.Result;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

/**
 * ResultService interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface ResultService {
    /**
     * Create new result
     *
     * @param score         score
     * @param applicationId applicationId
     * @param subjectId     subjectId
     * @return true if user get correctly, otherwise false
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    boolean createResult(double score, int applicationId, int subjectId) throws ServiceException;

    /**
     * Update result
     *
     * @param resultId  resultId
     * @param score     score
     * @param subjectId subjectId
     * @return true if user get correctly, otherwise false
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    boolean updateResult(int resultId, double score, int subjectId) throws ServiceException;

    /**
     * Get result by id
     *
     * @param id resultId
     * @return result if operation was correctly, otherwise null
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    Result getResultById(int id) throws ServiceException;

    /**
     * Get list of results by score
     *
     * @param score score
     * @return list of results
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<Result> getResultsByScore(double score) throws ServiceException;

    /**
     * Get list of results by applicationId
     *
     * @param applicationId applicationId
     * @return list of results
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<Result> getResultsByApplicationId(int applicationId) throws ServiceException;

    /**
     * Get list of results by subjectId
     *
     * @param subjectId subjectId
     * @return list of results
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<Result> getResultsBySubjectId(int subjectId) throws ServiceException;

    /**
     * Get list of all results
     *
     * @return list of all results
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<Result> getAllResults() throws ServiceException;

    /**
     * Delete result by id
     *
     * @param id resultId
     * @return 1 if operation was correctly, otherwise another value
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int deleteById(int id) throws ServiceException;

    /**
     * Count all results
     *
     * @return count of all results
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int countAllResults() throws ServiceException;
}
