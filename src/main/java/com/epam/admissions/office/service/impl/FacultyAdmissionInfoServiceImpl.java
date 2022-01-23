package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.dao.DaoFactory;
import com.epam.admissions.office.dao.FacultyAdmissionInfoDao;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.FacultyAdmissionInfo;
import com.epam.admissions.office.service.FacultyAdmissionInfoService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public class FacultyAdmissionInfoServiceImpl implements FacultyAdmissionInfoService {
    @Override
    public FacultyAdmissionInfo getFacultyAdmissionInfoById(int id) throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.getFacultyAdmissionInfoById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public FacultyAdmissionInfo getFacultyAdmissionInfoByFacultyId(int facultyId) throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.getFacultyAdmissionInfoByFacultyId(facultyId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<FacultyAdmissionInfo> getAllFacultyAdmissionInfos() throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.getAllFacultyAdmissionInfos();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPassingScore(double passingScore) throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.getFacultyAdmissionInfosByPassingScore(passingScore);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPlaces(double places) throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.getFacultyAdmissionInfosByPlaces(places);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int deleteById(int id) throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int countAllAdmissionInfos() throws ServiceException {
        FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();

        try {
            return facultyAdmissionInfoDao.countAllAdmissionInfos();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
