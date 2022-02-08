package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.faculty.FacultyAdmissionInfo;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

/**
 * FacultyAdmissionInfoService interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface FacultyAdmissionInfoService {
    /**
     * Get faculty admission info by id
     *
     * @param id id
     * @return faculty admission info if operation was correctly, otherwise null
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    FacultyAdmissionInfo getFacultyAdmissionInfoById(int id) throws ServiceException;

    /**
     * Get faculty admission info by facultyId
     *
     * @param facultyId facultyId
     * @return faculty admission info if operation was correctly, otherwise null
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    FacultyAdmissionInfo getFacultyAdmissionInfoByFacultyId(int facultyId) throws ServiceException;

    /**
     * Get list of all faculty admission infos
     *
     * @return list of all faculty admission infos
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<FacultyAdmissionInfo> getAllFacultyAdmissionInfos() throws ServiceException;

    /**
     * Get list of all faculty admission infos by passing score
     *
     * @param passingScore passing score
     * @return list of all faculty admission infos by passing score
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPassingScore(double passingScore) throws ServiceException;

    /**
     * Get list of all faculty admission infos by places
     *
     * @param places places
     * @return list of all faculty admission infos by places
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPlaces(double places) throws ServiceException;

    /**
     * Delete faculty admission info by id
     *
     * @param id id
     * @return 1 if operation was correctly, otherwise another value
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int deleteById(int id) throws ServiceException;

    /**
     * Update faculty admission info by id
     *
     * @param facultyAdmissionInfoId facultyAdmissionInfoId
     * @param passingScore           passingScore
     * @return 1 if operation was correctly, otherwise another value
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    boolean updateFacultyAdmissionInfo(int facultyAdmissionInfoId, double passingScore) throws ServiceException;

    /**
     * Count all faculty admission infos
     *
     * @return count of all faculty admission infos
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int countAllAdmissionInfos() throws ServiceException;
}
