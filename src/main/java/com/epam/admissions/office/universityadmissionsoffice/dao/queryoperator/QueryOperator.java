package com.epam.admissions.office.universityadmissionsoffice.dao.queryoperator;



import com.epam.admissions.office.universityadmissionsoffice.dao.DaoException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface QueryOperator<T> {
    void setStatementParams(PreparedStatement statement, Object... params) throws SQLException;

    List<T> executeQuery(String query, Object... params) throws DaoException;

    T executeSingleEntityQuery(String query, Object... params) throws DaoException;

    int executeUpdate(String query, Object... params) throws DaoException;

    int executeTransaction(List<ParametrizedQuery> queries) throws DaoException;
}
