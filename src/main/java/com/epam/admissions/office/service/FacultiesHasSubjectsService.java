package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.faculty.FacultyHasSubject;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public interface FacultiesHasSubjectsService {
    List<FacultyHasSubject> getSubjectsIdOfFacultyById(int facultyId) throws ServiceException;
}
