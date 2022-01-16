package com.epam.admissions.office.dao;


import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectDao {
    int create(Subject subject) throws DaoException;

    int update(int id) throws DaoException;

    int delete(int id) throws DaoException;

    Optional<Subject> getSubjectById(int id) throws DaoException;

    List<Subject> getSubjectsList() throws DaoException;

}
