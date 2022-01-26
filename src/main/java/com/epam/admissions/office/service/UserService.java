package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    User login(String email, String password) throws ServiceException;

    boolean signUp(String name, String surname, String email, String passportId, String password, String confirmPassword) throws ServiceException;

    User getById(int id) throws ServiceException;

    User getByEmail(String email) throws ServiceException;

    int deleteById(int id) throws ServiceException;

    int restoreById(int id) throws ServiceException;

    List<User> getAllUsers() throws ServiceException;

    int countAllUsers() throws ServiceException;

    List<User> getAllApplicants() throws ServiceException;

    List<User> getAllAdministrators() throws ServiceException;

    boolean editPersonalData(int id, String name, String surname, String email, String passportId) throws ServiceException;

    boolean changeUserRole(int id, UserRole userRole) throws ServiceException;

    List<User> getUsersByRoleId(int roleId) throws ServiceException;

    List<User> getUsersByStatus(String status) throws ServiceException;

    int countByUserRole(UserRole userRole) throws ServiceException;
}
