package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.FacultiesHasSubjectsDao;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.FacultyHasSubject;
import com.epam.admissions.office.service.FacultiesHasSubjectsService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

/**
 * FacultiesHasSubjectsServiceImpl class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class FacultiesHasSubjectsServiceImpl implements FacultiesHasSubjectsService {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<FacultyHasSubject> getSubjectsIdOfFacultyById(int facultyId) throws ServiceException {
        FacultiesHasSubjectsDao facultiesHasSubjectsDao = DaoFactory.getInstance().getFacultiesHasSubjectsDao();

        try {
            return facultiesHasSubjectsDao.getSubjectsIdOfFacultyById(facultyId);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }
}
