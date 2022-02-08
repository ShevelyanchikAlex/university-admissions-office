package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.faculty.Faculty;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

/**
 * FacultyService interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface FacultyService {
    /**
     * Get faculty by id
     *
     * @param id facultyId
     * @return faculty if operation was correctly, otherwise null
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    Faculty getFacultyById(int id) throws ServiceException;

    /**
     * Get list of all faculties
     *
     * @return list of all faculties
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<Faculty> getAllFaculties() throws ServiceException;

    /**
     * Delete faculty by id
     *
     * @param id facultyId
     * @return 1 if operation was correctly, otherwise another value
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int deleteById(int id) throws ServiceException;

    /**
     * Count all faculties
     *
     * @return count of all faculties
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int countAllFaculties() throws ServiceException;
}
