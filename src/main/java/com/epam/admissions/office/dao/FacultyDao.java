package com.epam.admissions.office.dao;



import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyDao {
    int create(Faculty faculty) throws DaoException;

    int update(int id) throws DaoException;

    int delete(int id) throws DaoException;

    Optional<Faculty> getFacultyById(int id) throws DaoException;

    Optional<Faculty> getFacultyByName(String facultyName) throws DaoException;

    Optional<Faculty> getFacultyByShortName(String facultyShortName) throws DaoException;

    List<Faculty> getFacultiesList() throws DaoException;
}
