package com.epam.admissions.office.service.impl;

import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.service.UserService;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void register(String firstName, String lastName, String email, String password) throws ServiceException {

    }

    @Override
    public User login(String email, String password) throws ServiceException {
        return null;
    }

    @Override
    public User getById(int id) throws ServiceException {
        return null;
    }

    @Override
    public User getByEmail(String email) throws ServiceException {
        return null;
    }

    @Override
    public List<User> getAll() throws ServiceException {
        return null;
    }

    @Override
    public int editPersonalData(int id, String name, String surname, String phoneNumber) throws ServiceException {
        return 0;
    }
}
