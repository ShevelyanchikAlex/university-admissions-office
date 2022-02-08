package com.epam.admissions.office.dao;

import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.FacultyHasSubject;

import java.util.List;

public interface FacultiesHasSubjectsDao {
    List<FacultyHasSubject> getSubjectsIdOfFacultyById(int facultyId) throws DaoException;
}
