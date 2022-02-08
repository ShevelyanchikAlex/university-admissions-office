package com.epam.admissions.office.dao;


import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.FacultyAdmissionInfo;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

/**
 * FacultyAdmissionInfoDao interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface FacultyAdmissionInfoDao {
    /**
     * Get faculty admission info by id
     *
     * @param id id
     * @return faculty admission info if operation was correctly, otherwise null
     * @throws DaoException if an exception is thrown while working with db
     */
    FacultyAdmissionInfo getFacultyAdmissionInfoById(int id) throws DaoException;

    /**
     * Get faculty admission info by facultyId
     *
     * @param facultyId facultyId
     * @return faculty admission info if operation was correctly, otherwise null
     * @throws DaoException if an exception is thrown while working with db
     */
    FacultyAdmissionInfo getFacultyAdmissionInfoByFacultyId(int facultyId) throws DaoException;

    /**
     * Get list of all faculty admission infos
     *
     * @return list of all faculty admission infos
     * @throws DaoException if an exception is thrown while working with db
     */
    List<FacultyAdmissionInfo> getAllFacultyAdmissionInfos() throws DaoException;

    /**
     * Get list of all faculty admission infos by passing score
     *
     * @param passingScore passing score
     * @return list of all faculty admission infos by passing score
     * @throws DaoException if an exception is thrown while working with db
     */
    List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPassingScore(double passingScore) throws DaoException;

    /**
     * Get list of all faculty admission infos by places
     *
     * @param places places
     * @return list of all faculty admission infos by places
     * @throws DaoException if an exception is thrown while working with db
     */
    List<FacultyAdmissionInfo> getFacultyAdmissionInfosByPlaces(double places) throws DaoException;

    /**
     * Delete faculty admission info by id
     *
     * @param id id
     * @return 1 if operation was correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int deleteById(int id) throws DaoException;

    /**
     * Update faculty admission info by id
     *
     * @param facultyAdmissionInfo faculty admission info
     * @return 1 if operation was correctly, otherwise another value
     * @throws ServiceException if an exception is thrown while working with validator
     * @throws DaoException     if an exception is thrown while working with db
     */
    int updateFacultyAdmissionInfo(FacultyAdmissionInfo facultyAdmissionInfo) throws ServiceException, DaoException;

    /**
     * Count all faculty admission infos
     *
     * @return count of all faculty admission infos
     * @throws DaoException if an exception is thrown while working with db
     */
    int countAllAdmissionInfos() throws DaoException;
}
