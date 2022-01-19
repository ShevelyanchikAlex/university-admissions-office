package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.faculty.FacultyAdmissionInfo;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public interface FacultyAdmissionInfoService {
    FacultyAdmissionInfo getFacultyAdmissionInfoById(int id) throws ServiceException;

    FacultyAdmissionInfo getFacultyAdmissionInfoByFacultyId(int facultyId) throws ServiceException;

    List<FacultyAdmissionInfo> getAllFacultyAdmissionInfos() throws ServiceException;

    List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPassingScore(double passingScore) throws ServiceException;

    List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPlaces(double places) throws ServiceException;

    int deleteById(int id) throws ServiceException;

    int countAllAdmissionInfos() throws ServiceException;
}
