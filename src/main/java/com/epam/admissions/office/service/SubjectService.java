package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.Subject;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

/**
 * SubjectService interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface SubjectService {
    /**
     * Get subject by id
     *
     * @param id subjectId
     * @return subject if subject by id get correctly, otherwise null
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    Subject getSubjectById(int id) throws ServiceException;

    /**
     * Get all subjects
     *
     * @return list of all subjects
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<Subject> getAllSubjects() throws ServiceException;

    /**
     * Delete subject by id
     *
     * @param id subjectId
     * @return 1 if operation was correctly, otherwise another value
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int deleteById(int id) throws ServiceException;

    /**
     * Count all subjects
     *
     * @return count of all subjects
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int countAllSubjects() throws ServiceException;
}
