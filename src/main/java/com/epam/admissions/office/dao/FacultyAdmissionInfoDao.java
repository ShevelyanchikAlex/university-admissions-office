package com.epam.admissions.office.dao;


import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.FacultyAdmissionInfo;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public interface FacultyAdmissionInfoDao {
    FacultyAdmissionInfo getFacultyAdmissionInfoById(int id) throws DaoException;

    FacultyAdmissionInfo getFacultyAdmissionInfoByFacultyId(int facultyId) throws DaoException;

    List<FacultyAdmissionInfo> getAllFacultyAdmissionInfos() throws DaoException;

    List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPassingScore(double passingScore) throws DaoException;

    List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPlaces(double places) throws DaoException;

    int deleteById(int id) throws DaoException;

    int updateFacultyAdmissionInfo(FacultyAdmissionInfo facultyAdmissionInfo) throws ServiceException, DaoException;

    int countAllAdmissionInfos() throws DaoException;
}
