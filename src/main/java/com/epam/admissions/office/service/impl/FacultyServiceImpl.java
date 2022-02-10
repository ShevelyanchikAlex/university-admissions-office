package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.FacultyDao;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.Faculty;
import com.epam.admissions.office.service.FacultyService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

/**
 * FacultyServiceImpl class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class FacultyServiceImpl implements FacultyService {
    private final FacultyDao facultyDao = DaoFactory.getInstance().getFacultyDao();

    /**
     * {@inheritDoc}
     */
    @Override
    public Faculty getFacultyById(int id) throws ServiceException {
        try {
            return facultyDao.getFacultyById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Faculty> getAllFaculties() throws ServiceException {
        try {
            return facultyDao.getAllFaculties();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteById(int id) throws ServiceException {
        try {
            return facultyDao.deleteById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countAllFaculties() throws ServiceException {
        try {
            return facultyDao.countAllFaculties();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }
}
