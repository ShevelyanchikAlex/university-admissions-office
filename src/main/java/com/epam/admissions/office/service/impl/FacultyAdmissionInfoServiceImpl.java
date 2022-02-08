package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.FacultyAdmissionInfoDao;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.FacultyAdmissionInfo;
import com.epam.admissions.office.service.FacultyAdmissionInfoService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public class FacultyAdmissionInfoServiceImpl implements FacultyAdmissionInfoService {
    private static final int SUCCESSFUL_OPERATION = 1;

    @Override
    public FacultyAdmissionInfo getFacultyAdmissionInfoById(int id) throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.getFacultyAdmissionInfoById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public FacultyAdmissionInfo getFacultyAdmissionInfoByFacultyId(int facultyId) throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.getFacultyAdmissionInfoByFacultyId(facultyId);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public List<FacultyAdmissionInfo> getAllFacultyAdmissionInfos() throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.getAllFacultyAdmissionInfos();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPassingScore(double passingScore) throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.getFacultyAdmissionInfosByPassingScore(passingScore);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPlaces(double places) throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.getFacultyAdmissionInfosByPlaces(places);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public int deleteById(int id) throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.deleteById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public boolean updateFacultyAdmissionInfo(int facultyAdmissionInfoId, double passingScore) throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            FacultyAdmissionInfo facultyAdmissionInfo = facultyAdmissionInfoDao.getFacultyAdmissionInfoByFacultyId(facultyAdmissionInfoId);
            facultyAdmissionInfo.setPassingScore(passingScore);
            return facultyAdmissionInfoDao.updateFacultyAdmissionInfo(facultyAdmissionInfo) == SUCCESSFUL_OPERATION;
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public int countAllAdmissionInfos() throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.countAllAdmissionInfos();
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }
}
