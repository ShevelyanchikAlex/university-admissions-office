package com.epam.admissions.office.dao.impl;


import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.dao.FacultyAdmissionInfoDao;
import com.epam.admissions.office.entity.faculty.FacultyAdmissionInfo;

import java.util.List;
import java.util.Optional;

public class FacultyAdmissionInfoImpl implements FacultyAdmissionInfoDao {
    @Override
    public int create(FacultyAdmissionInfo facultyAdmissionInfo) throws DaoException {
        return 0;
    }

    @Override
    public int update(int id) throws DaoException {
        return 0;
    }

    @Override
    public int delete(int id) throws DaoException {
        return 0;
    }

    @Override
    public Optional<FacultyAdmissionInfo> getFacultyAdmissionInfoById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<FacultyAdmissionInfo> getFacultyAdmissionInfoList() throws DaoException {
        return null;
    }
}
