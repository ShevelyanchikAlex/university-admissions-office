package com.epam.admissions.office.dao;

import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.faculty.Faculty;

import java.util.List;

public interface FacultyDao {
    Faculty getFacultyById(int id) throws DaoException;

    List<Faculty> getAllFaculties() throws DaoException;

    int deleteById(int id) throws DaoException;

    int countAllFaculties() throws DaoException;
}
