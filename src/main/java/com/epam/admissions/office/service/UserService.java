package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    User login(String email, String password) throws ServiceException;

    void signUp(String name, String surname, String email, String passportId, String password) throws ServiceException;

    User getById(int id) throws ServiceException;

    User getByEmail(String email) throws ServiceException;

    int deleteById(int id) throws ServiceException;

    int restoreById(int id) throws ServiceException;

    List<User> getAllUsers() throws ServiceException;

    int countAllUsers() throws ServiceException;

    int editPersonalData(int id, String name, String surname, String email, String passportId, String password) throws ServiceException;

    List<User> getUsersByRoleId(int roleId) throws ServiceException;

    List<User> getUsersByStatus(String status) throws ServiceException;

    int countByUserRole(UserRole userRole) throws ServiceException;
}
