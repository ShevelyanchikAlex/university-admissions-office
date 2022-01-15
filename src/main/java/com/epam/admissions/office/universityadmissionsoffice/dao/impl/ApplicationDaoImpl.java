package com.epam.admissions.office.universityadmissionsoffice.dao.impl;



import com.epam.admissions.office.universityadmissionsoffice.dao.ApplicationDao;
import com.epam.admissions.office.universityadmissionsoffice.dao.DaoException;
import com.epam.admissions.office.universityadmissionsoffice.entity.Application;

import java.util.List;
import java.util.Optional;

public class ApplicationDaoImpl implements ApplicationDao {
    @Override
    public int create(Application application) throws DaoException {
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
    public Optional<Application> getApplicationById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Application> getApplicationByUserId(int userId) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Application> getApplicationsList() throws DaoException {
        return null;
    }
}
