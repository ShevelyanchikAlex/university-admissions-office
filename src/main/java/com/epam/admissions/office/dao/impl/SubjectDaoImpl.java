package com.epam.admissions.office.dao.impl;



import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.dao.SubjectDao;
import com.epam.admissions.office.entity.Subject;

import java.util.List;
import java.util.Optional;

public class SubjectDaoImpl implements SubjectDao {
    @Override
    public int create(Subject subject) throws DaoException {
        return 0;
    }

    @Override
    public int update(int id) throws DaoException {
        return 0;
    }

    @Override
    public int delete(int id) throws DaoException {
        return 0;
    }

    @Override
    public Optional<Subject> getSubjectById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Subject> getSubjectsList() throws DaoException {
        return null;
    }
}
