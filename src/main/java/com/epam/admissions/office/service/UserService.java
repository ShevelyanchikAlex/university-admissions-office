package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    void register(String firstName, String lastName, String email, String password) throws ServiceException;

    User login(String email, String password) throws ServiceException;

    User getById(int id) throws ServiceException;

    User getByEmail(String email) throws ServiceException;

    List<User> getAll() throws ServiceException;

    int editPersonalData(int id, String name, String surname, String phoneNumber) throws ServiceException;
}
