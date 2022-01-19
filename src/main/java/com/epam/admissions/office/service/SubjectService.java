package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.Subject;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public interface SubjectService {
    Subject getSubjectById(int id) throws ServiceException;

    List<Subject> getAllSubjects() throws ServiceException;

    int deleteById(int id) throws ServiceException;

    int countAllSubjects() throws ServiceException;
}
