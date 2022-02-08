package com.epam.admissions.office.dao;

import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;

import java.util.List;

/**
 * UserDao interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface UserDao {
    /**
     * Create new user
     *
     * @param user user
     * @return 1 if user added correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int createUser(User user) throws DaoException;

    /**
     * Update user
     *
     * @param user updated user
     * @return 1 if user added correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int updateUser(User user) throws DaoException;

    /**
     * Get user by userId
     *
     * @param id userId
     * @return user if user get correctly, otherwise null
     * @throws DaoException if an exception is thrown while working with db
     */
    User getUserById(int id) throws DaoException;

    /**
     * Get user by email
     *
     * @param email user's email
     * @return user if user get correctly, otherwise null
     * @throws DaoException if an exception is thrown while working with db
     */
    User getByEmail(String email) throws DaoException;

    /**
     * Get user by userRole
     *
     * @param userRole userRole
     * @return user if user get correctly, otherwise null
     * @throws DaoException if an exception is thrown while working with db
     */
    User getByUserRole(UserRole userRole) throws DaoException;

    /**
     * Get list of all users
     *
     * @return list of all users
     * @throws DaoException if an exception is thrown while working with db
     */
    List<User> getAllUsers() throws DaoException;

    /**
     * Get list of all applicants
     *
     * @return list of applicants
     * @throws DaoException if an exception is thrown while working with db
     */
    List<User> getAllApplicants() throws DaoException;

    /**
     * Get list of all administrators
     *
     * @return list of administrators
     * @throws DaoException if an exception is thrown while working with db
     */
    List<User> getAllAdministrators() throws DaoException;

    /**
     * Get list of users by userRoleId
     *
     * @param roleId userRoleId
     * @return list of users by userRoleId
     * @throws DaoException if an exception is thrown while working with db
     */
    List<User> getUsersByRoleId(int roleId) throws DaoException;

    /**
     * Get list of users by status
     *
     * @param status userStatus
     * @return list of users by userStatus
     * @throws DaoException if an exception is thrown while working with db
     */
    List<User> getUsersByStatus(String status) throws DaoException;

    /**
     * Delete user by id
     *
     * @param id id
     * @return 1 if user added correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int deleteById(int id) throws DaoException;

    /**
     * Restore user by id
     *
     * @param id id
     * @return 1 if user added correctly, otherwise another value
     * @throws DaoException if an exception is thrown while working with db
     */
    int restoreById(int id) throws DaoException;

    /**
     * Count all users
     *
     * @return count of all users
     * @throws DaoException if an exception is thrown while working with db
     */
    int countAllUsers() throws DaoException;

    /**
     * Count users by userRole
     *
     * @param userRole userRole
     * @return count of users by userRole
     * @throws DaoException if an exception is thrown while working with db
     */
    int countByUserRole(UserRole userRole) throws DaoException;
}
