package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.FacultyAdmissionInfoDao;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.FacultyAdmissionInfo;
import com.epam.admissions.office.service.FacultyAdmissionInfoService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

/**
 * FacultyAdmissionInfoServiceImpl class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class FacultyAdmissionInfoServiceImpl implements FacultyAdmissionInfoService {
    private static final int SUCCESSFUL_OPERATION = 1;

    private final FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

    /**
     * {@inheritDoc}
     */
    @Override
    public FacultyAdmissionInfo getFacultyAdmissionInfoById(int id) throws ServiceException {
        try {
            return facultyAdmissionInfoDao.getFacultyAdmissionInfoById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FacultyAdmissionInfo getFacultyAdmissionInfoByFacultyId(int facultyId) throws ServiceException {
        try {
            return facultyAdmissionInfoDao.getFacultyAdmissionInfoByFacultyId(facultyId);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FacultyAdmissionInfo> getAllFacultyAdmissionInfos() throws ServiceException {
        try {
            return facultyAdmissionInfoDao.getAllFacultyAdmissionInfos();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPassingScore(double passingScore) throws ServiceException {
        try {
            return facultyAdmissionInfoDao.getFacultyAdmissionInfosByPassingScore(passingScore);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPlaces(double places) throws ServiceException {
        try {
            return facultyAdmissionInfoDao.getFacultyAdmissionInfosByPlaces(places);
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
            return facultyAdmissionInfoDao.deleteById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean updateFacultyAdmissionInfo(int facultyAdmissionInfoId, double passingScore) throws ServiceException {
        try {
            FacultyAdmissionInfo facultyAdmissionInfo = facultyAdmissionInfoDao.getFacultyAdmissionInfoByFacultyId(facultyAdmissionInfoId);
            facultyAdmissionInfo.setPassingScore(passingScore);
            return facultyAdmissionInfoDao.updateFacultyAdmissionInfo(facultyAdmissionInfo) == SUCCESSFUL_OPERATION;
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countAllAdmissionInfos() throws ServiceException {
        try {
            return facultyAdmissionInfoDao.countAllAdmissionInfos();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }
}
