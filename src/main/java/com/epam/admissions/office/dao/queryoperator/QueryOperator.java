package com.epam.admissions.office.dao.queryoperator;


import com.epam.admissions.office.dao.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface QueryOperator<T> {
    List<T> executeQuery(String query, Object... params) throws DaoException;

    T executeSingleEntityQuery(String query, Object... params) throws DaoException;

    int executeUpdate(String query, Object... params) throws DaoException;

    int executeUpdateWithGeneratedKeys(String query, Object... params) throws DaoException;

    int executeCountQuery(String query, Object... params) throws DaoException;

    void setStatementParams(PreparedStatement statement, Object... params) throws SQLException;
}