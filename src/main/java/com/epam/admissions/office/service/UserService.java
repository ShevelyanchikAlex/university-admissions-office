package com.epam.admissions.office.service;

import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;
import com.epam.admissions.office.service.exception.ServiceException;

import java.util.List;

/**
 * UserService interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface UserService {
    /**
     * Login user
     *
     * @param email    email
     * @param password password
     * @return user if user get correctly, otherwise null
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    User login(String email, String password) throws ServiceException;

    /**
     * SignUp user
     *
     * @param name            name
     * @param surname         surname
     * @param email           email
     * @param passportId      passportId
     * @param password        password
     * @param confirmPassword confirmPassword
     * @return true if user get correctly, otherwise false
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    boolean signUp(String name, String surname, String email, String passportId, String password, String confirmPassword) throws ServiceException;

    /**
     * Get user by id
     *
     * @param id userId
     * @return user if user get correctly, otherwise null
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    User getById(int id) throws ServiceException;

    /**
     * Get user by email
     *
     * @param email email
     * @return user if user get correctly, otherwise null
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    User getByEmail(String email) throws ServiceException;

    /**
     * Delete user by id
     *
     * @param id id
     * @return 1 if user added correctly, otherwise another value
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int deleteById(int id) throws ServiceException;

    /**
     * Restore user by id
     *
     * @param id id
     * @return 1 if user added correctly, otherwise another value
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int restoreById(int id) throws ServiceException;

    /**
     * Get list of all users
     *
     * @return list of all users
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<User> getAllUsers() throws ServiceException;

    /**
     * Count all users
     *
     * @return count of all users
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int countAllUsers() throws ServiceException;

    /**
     * Get list of all applicants
     *
     * @return list of applicants
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<User> getAllApplicants() throws ServiceException;

    /**
     * Get list of all administrators
     *
     * @return list of administrators
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<User> getAllAdministrators() throws ServiceException;

    /**
     * Edit personal data
     *
     * @param id         id
     * @param name       name
     * @param surname    surname
     * @param email      email
     * @param passportId passportId
     * @return true if user get correctly, otherwise false
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    boolean editPersonalData(int id, String name, String surname, String email, String passportId) throws ServiceException;

    /**
     * Change user role
     *
     * @param id       id
     * @param userRole userRole
     * @return true if user get correctly, otherwise false
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    boolean changeUserRole(int id, UserRole userRole) throws ServiceException;

    /**
     * Get list of users by userRoleId
     *
     * @param roleId userRoleId
     * @return list of users by userRoleId
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<User> getUsersByRoleId(int roleId) throws ServiceException;

    /**
     * Get list of users by status
     *
     * @param status userStatus
     * @return list of users by userStatus
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    List<User> getUsersByStatus(String status) throws ServiceException;

    /**
     * Count users by userRole
     *
     * @param userRole userRole
     * @return count of users by userRole
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    int countByUserRole(UserRole userRole) throws ServiceException;
}
