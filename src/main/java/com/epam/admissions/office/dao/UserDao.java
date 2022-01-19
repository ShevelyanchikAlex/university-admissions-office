package com.epam.admissions.office.dao;

import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;

import java.util.List;

public interface UserDao {
    User getUserById(int id) throws DaoException;

    User getByEmail(String email) throws DaoException;

    User getByUserRole(UserRole userRole) throws DaoException;

    List<User> getAllUsers() throws DaoException;

    List<User> getUsersListByRoleId(int roleId) throws DaoException;

    List<User> getUsersListByStatus(String status) throws DaoException;

    int deleteById(int id) throws DaoException;

    int restoreById(int id) throws DaoException;

    int countAllUsers() throws DaoException;

    int countByUserRole(UserRole userRole) throws DaoException;
}
