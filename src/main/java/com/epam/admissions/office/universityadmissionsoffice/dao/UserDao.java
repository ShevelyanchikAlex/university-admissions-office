package com.epam.admissions.office.universityadmissionsoffice.dao;


import com.epam.admissions.office.universityadmissionsoffice.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    int create(User user) throws DaoException;

    int update(User user) throws DaoException;

    int delete(int id) throws DaoException;

    int getMaxId() throws DaoException;

    Optional<User> getUserById(int id) throws DaoException;

    User getByEmail(String email) throws DaoException;

    List<User> getUsersList() throws DaoException;

    List<User> getUsersListByRoleId(int roleId) throws DaoException;

    List<User> getUsersListByStatus(String status) throws DaoException;

}
