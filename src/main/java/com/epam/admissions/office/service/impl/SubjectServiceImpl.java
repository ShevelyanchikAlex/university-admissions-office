package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.SubjectDao;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.Subject;
import com.epam.admissions.office.service.SubjectService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

/**
 * SubjectServiceImpl class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class SubjectServiceImpl implements SubjectService {
    /**
     * {@inheritDoc}
     */
    @Override
    public Subject getSubjectById(int id) throws ServiceException {
        SubjectDao subjectDao = DaoFactory.getInstance().getSubjectDao();

        try {
            return subjectDao.getSubjectById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Subject> getAllSubjects() throws ServiceException {
        SubjectDao subjectDao = DaoFactory.getInstance().getSubjectDao();

        try {
            return subjectDao.getAllSubjects();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteById(int id) throws ServiceException {
        SubjectDao subjectDao = DaoFactory.getInstance().getSubjectDao();

        try {
            return subjectDao.deleteById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countAllSubjects() throws ServiceException {
        SubjectDao subjectDao = DaoFactory.getInstance().getSubjectDao();

        try {
            return subjectDao.countAllSubjects();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }
}
