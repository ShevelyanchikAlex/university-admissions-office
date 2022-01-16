package com.epam.admissions.office.dao.impl;


import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.dao.UserDao;
import com.epam.admissions.office.dao.constant.DBRequest;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.dao.mapper.RowMapperFactory;
import com.epam.admissions.office.dao.queryoperator.QueryOperator;
import com.epam.admissions.office.dao.queryoperator.impl.QueryOperatorImpl;
import com.epam.admissions.office.entity.user.User;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    protected final RowMapper<User> mapper;
    protected final QueryOperator<User> queryOperator;

    public UserDaoImpl() {
        this.mapper = RowMapperFactory.getUserRowMapper();
        this.queryOperator = new QueryOperatorImpl<>(mapper);
    }


    @Override
    public int create(User user) throws DaoException {
        return queryOperator.executeUpdate(
                DBRequest.CREATE_USER_QUERY,
                user.getUserId(),
                user.getSurname(),
                user.getPasswordHash(),
                user.getEmail(),
                user.getPassportId(),
                user.getUserStatus(),
                user.getUserRole());
    }

    @Override
    public int update(User user) throws DaoException {
        return queryOperator.executeUpdate(
                DBRequest.UPDATE_USER_QUERY,
                user.getSurname(),
                user.getPasswordHash(),
                user.getEmail(),
                user.getPassportId(),
                user.getUserStatus(),
                user.getUserRole(),
                user.getUserId());
    }

    @Override
    public int delete(int id) throws DaoException {
        return queryOperator.executeUpdate(DBRequest.DELETE_USER_QUERY, id);
    }


    @Override
    public int getMaxId() throws DaoException {
        return 0;
    }


    @Override
    public Optional<User> getUserById(int id) throws DaoException {
        return Optional.ofNullable(queryOperator.executeSingleEntityQuery(DBRequest.GET_BY_ID_QUERY, id));
    }

    @Override
    public User getByEmail(String email) throws DaoException {
        return null;
    }

    @Override
    public List<User> getUsersList() throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_ALL_QUERY);
    }

    @Override
    public List<User> getUsersListByRoleId(int roleId) throws DaoException {
        return queryOperator.executeQuery(DBRequest.GET_BY_ROLE_ID_QUERY, roleId);
    }

    @Override
    public List<User> getUsersListByStatus(String status) throws DaoException {
        return null;
    }
}
