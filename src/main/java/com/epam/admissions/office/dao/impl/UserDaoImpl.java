package com.epam.admissions.office.dao.impl;

import com.epam.admissions.office.dao.UserDao;
import com.epam.admissions.office.dao.constant.DBRequest;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.dao.mapper.RowMapperFactory;
import com.epam.admissions.office.dao.queryoperator.QueryOperator;
import com.epam.admissions.office.dao.queryoperator.impl.QueryOperatorImpl;
import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private final QueryOperator<User> queryOperator;

    public UserDaoImpl() {
        RowMapper<User> mapper = RowMapperFactory.getUserRowMapper();
        this.queryOperator = new QueryOperatorImpl<>(mapper);
    }

    @Override
    public int createUser(User user) throws DaoException {
        return queryOperator.executeUpdate(
                DBRequest.INSERT_USER_QUERY,
                user.getPasswordHash(),
                user.getEmail(),
                user.getName(),
                user.getSurname(),
                user.getPassportId(),
                user.isDeleted() ? 1 : 0,
                user.getUserRole().ordinal());
    }

    @Override
    public int updateUser(User user) throws DaoException {
        return queryOperator.executeUpdate(
                DBRequest.UPDATE_USER_QUERY,
                user.getPasswordHash(),
                user.getEmail(),
                user.getName(),
                user.getSurname(),
                user.getPassportId(),
                user.isDeleted() ? 1 : 0,
                user.getUserRole().ordinal(),
                user.getUserId());
    }

    @Override
    public User getUserById(int id) throws DaoException {
        return queryOperator.executeSingleEntityQuery(DBRequest.GET_USER_BY_ID_QUERY, id);

    }

    @Override
    public User getByEmail(String email) throws DaoException {
        return queryOperator.executeSingleEntityQuery(DBRequest.GET_USER_BY_EMAIL_QUERY, email);

    }

    @Override
    public User getByUserRole(UserRole userRole) throws DaoException {
        return queryOperator.executeSingleEntityQuery(DBRequest.GET_USER_BY_USER_ROLE_ID_QUERY, userRole);
    }

    @Override
    public List<User> getAllUsers() throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_ALL_USERS_QUERY);
    }

    @Override
    public List<User> getAllApplicants() throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_ALL_APPLICANTS_QUERY);
    }

    @Override
    public List<User> getAllAdministrators() throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_ALL_ADMINISTRATORS_QUERY);
    }

    @Override
    public List<User> getUsersByRoleId(int roleId) throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_USER_BY_USER_ROLE_ID_QUERY, roleId);
    }

    @Override
    public List<User> getUsersByStatus(String status) throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_ALL_USERS_QUERY, status);
    }

    @Override
    public int deleteById(int id) throws DaoException {
        return queryOperator.executeUpdate(DBRequest.DELETE_USER_QUERY, id);
    }

    @Override
    public int restoreById(int id) throws DaoException {
        return queryOperator.executeUpdate(DBRequest.RESTORE_USER_QUERY, id);
    }

    @Override
    public int countAllUsers() throws DaoException {
        return queryOperator.executeCountQuery(DBRequest.COUNT_ALL_USERS_QUERY);
    }

    @Override
    public int countByUserRole(UserRole userRole) throws DaoException {
        return queryOperator.executeCountQuery(DBRequest.COUNT_USERS_BY_ROLE_ID_QUERY, userRole.ordinal());
    }
}
