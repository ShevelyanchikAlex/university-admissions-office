package com.epam.admissions.office.universityadmissionsoffice.dao.impl;


import com.epam.admissions.office.universityadmissionsoffice.dao.DaoException;
import com.epam.admissions.office.universityadmissionsoffice.dao.FacultyDao;
import com.epam.admissions.office.universityadmissionsoffice.entity.faculty.Faculty;

import java.util.List;
import java.util.Optional;

public class FacultyDaoImpl implements FacultyDao {
    @Override
    public int create(Faculty faculty) throws DaoException {
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
    public Optional<Faculty> getFacultyById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Faculty> getFacultyByName(String facultyName) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Faculty> getFacultyByShortName(String facultyShortName) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Faculty> getFacultiesList() throws DaoException {
        return null;
    }
}
