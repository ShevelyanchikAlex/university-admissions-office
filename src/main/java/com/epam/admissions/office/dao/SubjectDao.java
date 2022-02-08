package com.epam.admissions.office.dao;

import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Subject;

import java.util.List;

/**
 * SubjectDao interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface SubjectDao {
    /**
     * Get subject by id
     *
     * @param id subjectId
     * @return subject if subject by id get correctly, otherwise null
     * @throws DaoException if an exception is thrown while working with db
     */
    Subject getSubjectById(int id) throws DaoException;

    /**
     * Get all subjects
     *
     * @return list of all subjects
     * @throws DaoException if an exception is thrown while working with db
     */
    List<Subject> getAllSubjects() throws DaoException;

    /**
     * Delete subject by id
     *
     * @param id subjectId
     * @return 1 if operation was correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int deleteById(int id) throws DaoException;

    /**
     * Count all subjects
     *
     * @return count of all subjects
     * @throws DaoException if an exception is thrown while working with db
     */
    int countAllSubjects() throws DaoException;
}
