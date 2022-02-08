package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.FacultyDao;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.Faculty;
import com.epam.admissions.office.entity.faculty.FacultyHasSubject;
import com.epam.admissions.office.service.FacultyService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public class FacultyServiceImpl implements FacultyService {
    @Override
    public Faculty getFacultyById(int id) throws ServiceException {
        FacultyDao facultyDao = DaoFactory.getInstance().getFacultyDao();

        try {
            return facultyDao.getFacultyById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public List<Faculty> getAllFaculties() throws ServiceException {
        FacultyDao facultyDao = DaoFactory.getInstance().getFacultyDao();

        try {
            return facultyDao.getAllFaculties();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public int deleteById(int id) throws ServiceException {
        FacultyDao facultyDao = DaoFactory.getInstance().getFacultyDao();

        try {
            return facultyDao.deleteById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public int countAllFaculties() throws ServiceException {
        FacultyDao facultyDao = DaoFactory.getInstance().getFacultyDao();

        try {
            return facultyDao.countAllFaculties();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }
}
