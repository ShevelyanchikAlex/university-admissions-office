package com.epam.admissions.office.dao;

import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.FacultyHasSubject;

import java.util.List;

/**
 * FacultiesHasSubjectsDao interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface FacultiesHasSubjectsDao {
    /**
     * Get list of faculty has subject
     *
     * @param facultyId facultyId
     * @return list of faculty has subject
     * @throws DaoException if an exception is thrown while working with db
     */
    List<FacultyHasSubject> getSubjectsIdOfFacultyById(int facultyId) throws DaoException;
}
