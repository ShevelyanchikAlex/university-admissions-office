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
        try {
            FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();
            return facultyAdmissionInfoDao.getFacultyAdmissionInfoById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public FacultyAdmissionInfo getFacultyAdmissionInfoByFacultyId(int facultyId) throws ServiceException {
        try {
            FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();
            return facultyAdmissionInfoDao.getFacultyAdmissionInfoByFacultyId(facultyId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<FacultyAdmissionInfo> getAllFacultyAdmissionInfos() throws ServiceException {
        try {
            FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();
            return facultyAdmissionInfoDao.getAllFacultyAdmissionInfos();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPassingScore(double passingScore) throws ServiceException {
        try {
            FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();
            return facultyAdmissionInfoDao.getFacultyAdmissionInfosByPassingScore(passingScore);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPlaces(double places) throws ServiceException {
        try {
            FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();
            return facultyAdmissionInfoDao.getFacultyAdmissionInfosByPlaces(places);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int deleteById(int id) throws ServiceException {
        try {
            FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();
            return facultyAdmissionInfoDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int countAllAdmissionInfos() throws ServiceException {
        try {
            FacultyAdmissionInfoDao facultyAdmissionInfoDao = DaoFactory.getInstance().getFacultyAdmissionInfoDao();
            return facultyAdmissionInfoDao.countAllAdmissionInfos();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
