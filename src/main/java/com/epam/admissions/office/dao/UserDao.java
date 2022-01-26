package com.epam.admissions.office.dao;

import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

public interface UserDao {
    int createUser(User user) throws DaoException;

    int updateUser(User user) throws DaoException;

    User getUserById(int id) throws DaoException;

    User getByEmail(String email) throws DaoException;

    User getByUserRole(UserRole userRole) throws DaoException;

    List<User> getAllUsers() throws DaoException;

    List<User> getAllApplicants() throws DaoException;

    List<User> getAllAdministrators() throws DaoException;

    List<User> getUsersByRoleId(int roleId) throws DaoException;

    List<User> getUsersByStatus(String status) throws DaoException;

    int deleteById(int id) throws DaoException;

    int restoreById(int id) throws DaoException;

    int countAllUsers() throws DaoException;

    int countByUserRole(UserRole userRole) throws DaoException;
}
