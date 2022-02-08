package com.epam.admissions.office.dao.queryoperator;


import com.epam.admissions.office.dao.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * QueryOperator interface.
 * Provides methods to execute various types of database queries.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface QueryOperator<T> {
    /**
     * Executes query
     *
     * @param query  query
     * @param params params
     * @return list of entities
     * @throws DaoException if an exception is thrown while working with db
     */
    List<T> executeQuery(String query, Object... params) throws DaoException;

    /**
     * Executes single entity query
     *
     * @param query  query
     * @param params params
     * @return entity
     * @throws DaoException if an exception is thrown while working with db
     */
    T executeSingleEntityQuery(String query, Object... params) throws DaoException;

    /**
     * Executes update query
     *
     * @param query  query
     * @param params params
     * @return result of database query
     * @throws DaoException if an exception is thrown while working with db
     */
    int executeUpdate(String query, Object... params) throws DaoException;

    /**
     * Executes update with generated keys query
     *
     * @param query  query
     * @param params params
     * @return generated key
     * @throws DaoException if an exception is thrown while working with db
     */
    int executeUpdateWithGeneratedKeys(String query, Object... params) throws DaoException;

    /**
     * Executes count query
     *
     * @param query  query
     * @param params params
     * @return count
     * @throws DaoException if an exception is thrown while working with db
     */
    int executeCountQuery(String query, Object... params) throws DaoException;

    /**
     * Sets PreparedStatement params
     *
     * @param statement statement
     * @param params    params
     * @throws SQLException sql exception
     */
    void setStatementParams(PreparedStatement statement, Object... params) throws SQLException;
}