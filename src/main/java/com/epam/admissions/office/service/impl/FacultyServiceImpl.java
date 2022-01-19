package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.FacultyDao;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.Faculty;
import com.epam.admissions.office.service.FacultyService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public class FacultyServiceImpl implements FacultyService {
    @Override
    public Faculty getFacultyById(int id) throws ServiceException {
        try {
            FacultyDao facultyDao = DaoFactory.getInstance().getFacultyDao();
            return facultyDao.getFacultyById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Faculty> getAllFaculties() throws ServiceException {
        try {
            FacultyDao facultyDao = DaoFactory.getInstance().getFacultyDao();
            return facultyDao.getAllFaculties();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int deleteById(int id) throws ServiceException {
        try {
            FacultyDao facultyDao = DaoFactory.getInstance().getFacultyDao();
            return facultyDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int countAllFaculties() throws ServiceException {
        try {
            FacultyDao facultyDao = DaoFactory.getInstance().getFacultyDao();
            return facultyDao.countAllFaculties();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
