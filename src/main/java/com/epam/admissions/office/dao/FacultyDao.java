package com.epam.admissions.office.dao;

import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.Faculty;

import java.util.List;

/**
 * FacultyDao interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface FacultyDao {
    /**
     * Get faculty by id
     *
     * @param id facultyId
     * @return faculty if operation was correctly, otherwise null
     * @throws DaoException if an exception is thrown while working with db
     */
    Faculty getFacultyById(int id) throws DaoException;

    /**
     * Get list of all faculties
     *
     * @return list of all faculties
     * @throws DaoException if an exception is thrown while working with db
     */
    List<Faculty> getAllFaculties() throws DaoException;

    /**
     * Delete faculty by id
     *
     * @param id facultyId
     * @return 1 if operation was correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int deleteById(int id) throws DaoException;

    /**
     * Count all faculties
     *
     * @return count of all faculties
     * @throws DaoException if an exception is thrown while working with db
     */
    int countAllFaculties() throws DaoException;
}
