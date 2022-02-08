package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.faculty.FacultyHasSubject;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

/**
 * FacultiesHasSubjectsService interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface FacultiesHasSubjectsService {
    /**
     * Get list of faculty has subject
     *
     * @param facultyId facultyId
     * @return list of faculty has subject
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<FacultyHasSubject> getSubjectsIdOfFacultyById(int facultyId) throws ServiceException;
}
