package com.epam.admissions.office.dao.queryoperator.impl;


import com.epam.admissions.office.dao.connection.ConnectionPool;
import com.epam.admissions.office.dao.connection.exception.ConnectionPoolException;
import com.epam.admissions.office.dao.exception.DaoException;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.dao.queryoperator.QueryOperator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryOperatorImpl<T> implements QueryOperator<T> {
    private static final int COLUMN_INDEX = 1;
    private static final String COLUMN_LABEL = "COUNT(*)";

    private final RowMapper<T> mapper;

    public QueryOperatorImpl(RowMapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<T> executeQuery(String query, Object... params) throws DaoException {
        List<T> resultList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            setStatementParams(statement, params);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                resultList.add(entity);
            }
        } catch (SQLException exception) {
            throw new DaoException("Unable to execute select query.", exception);
        } catch (ConnectionPoolException exception) {
            throw new DaoException("Unable to get connection.", exception);
        }
        return resultList;
    }

    @Override
    public int executeUpdate(String query, Object... params) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            setStatementParams(statement, params);
            return statement.executeUpdate();
        } catch (SQLException exception) {
            throw new DaoException("Unable to execute update query.", exception);
        } catch (ConnectionPoolException exception) {
            throw new DaoException("Unable to get connection.", exception);
        }
    }

    @Override
    public int executeUpdateWithGeneratedKeys(String query, Object... params) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            setStatementParams(statement, params);
            int numberInsertedRows = statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys != null && generatedKeys.next()) {
                return generatedKeys.getInt(COLUMN_INDEX);
            } else {
                return numberInsertedRows;
            }
        } catch (SQLException exception) {
            throw new DaoException("Unable to execute update query.", exception);
        } catch (ConnectionPoolException exception) {
            throw new DaoException("Unable to get connection.", exception);
        }
    }

    @Override
    public int executeCountQuery(String query, Object... params) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            setStatementParams(statement, params);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(COLUMN_LABEL);
        } catch (SQLException exception) {
            throw new DaoException("Unable to execute select query.", exception);
        } catch (ConnectionPoolException exception) {
            throw new DaoException("Unable to get connection.", exception);
        }
    }

    @Override
    public void setStatementParams(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }

    @Override
    public T executeSingleEntityQuery(String query, Object... params) throws DaoException {
        List<T> result = executeQuery(query, params);
        if (result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }
}
