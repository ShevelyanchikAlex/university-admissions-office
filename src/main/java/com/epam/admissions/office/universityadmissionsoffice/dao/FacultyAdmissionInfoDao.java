package com.epam.admissions.office.universityadmissionsoffice.dao;



import com.epam.admissions.office.universityadmissionsoffice.entity.faculty.FacultyAdmissionInfo;

import java.util.List;
import java.util.Optional;

public interface FacultyAdmissionInfoDao {
    int create(FacultyAdmissionInfo facultyAdmissionInfo) throws DaoException;

    int update(int id) throws DaoException;

    int delete(int id) throws DaoException;

    Optional<FacultyAdmissionInfo> getFacultyAdmissionInfoById(int id) throws DaoException;

    List<FacultyAdmissionInfo> getFacultyAdmissionInfoList() throws DaoException;
}
