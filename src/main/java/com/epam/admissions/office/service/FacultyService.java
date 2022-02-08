package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.faculty.Faculty;
import com.epam.admissions.office.entity.faculty.FacultyHasSubject;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public interface FacultyService {
    Faculty getFacultyById(int id) throws ServiceException;

    List<Faculty> getAllFaculties() throws ServiceException;

    int deleteById(int id) throws ServiceException;

    int countAllFaculties() throws ServiceException;
}
