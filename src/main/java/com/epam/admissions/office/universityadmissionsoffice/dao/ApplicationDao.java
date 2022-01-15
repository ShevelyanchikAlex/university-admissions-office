package com.epam.admissions.office.universityadmissionsoffice.dao;


import com.epam.admissions.office.universityadmissionsoffice.entity.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationDao {
    int create(Application application) throws DaoException;

    int update(int id) throws DaoException;

    int delete(int id) throws DaoException;

    Optional<Application> getApplicationById(int id) throws DaoException;

    Optional<Application> getApplicationByUserId(int userId) throws DaoException;

    List<Application> getApplicationsList() throws DaoException;
}
