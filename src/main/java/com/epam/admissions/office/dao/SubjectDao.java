package com.epam.admissions.office.dao;

import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Subject;

import java.util.List;

public interface SubjectDao {
    Subject getSubjectById(int id) throws DaoException;

    List<Subject> getAllSubjects() throws DaoException;

    int deleteById(int id) throws DaoException;

    int countAllSubjects() throws DaoException;
}
