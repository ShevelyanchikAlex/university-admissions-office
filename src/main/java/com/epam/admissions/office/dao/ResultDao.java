package com.epam.admissions.office.dao;

import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Result;

import java.util.List;

/**
 * ResultDao interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface ResultDao {
    /**
     * Create new result
     *
     * @param result result
     * @return 1 if operation was correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int createResult(Result result) throws DaoException;

    /**
     * Update result
     *
     * @param result result
     * @return 1 if operation was correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int updateResult(Result result) throws DaoException;

    /**
     * Get result by id
     *
     * @param id resultId
     * @return result if operation was correctly, otherwise null
     * @throws DaoException if an exception is thrown while working with db
     */
    Result getResultById(int id) throws DaoException;

    /**
     * Get list of results by score
     *
     * @param score score
     * @return list of results
     * @throws DaoException if an exception is thrown while working with db
     */
    List<Result> getResultsByScore(double score) throws DaoException;

    /**
     * Get list of results by applicationId
     *
     * @param applicationId applicationId
     * @return list of results
     * @throws DaoException if an exception is thrown while working with db
     */
    List<Result> getResultsByApplicationId(int applicationId) throws DaoException;

    /**
     * Get list of results by subjectId
     *
     * @param subjectId subjectId
     * @return list of results
     * @throws DaoException if an exception is thrown while working with db
     */
    List<Result> getResultsBySubjectId(int subjectId) throws DaoException;

    /**
     * Get list of all results
     *
     * @return list of all results
     * @throws DaoException if an exception is thrown while working with db
     */
    List<Result> getAllResults() throws DaoException;

    /**
     * Delete result by id
     *
     * @param id resultId
     * @return 1 if operation was correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int deleteById(int id) throws DaoException;

    /**
     * Count all results
     *
     * @return count of all results
     * @throws DaoException if an exception is thrown while working with db
     */
    int countAllResults() throws DaoException;
}
