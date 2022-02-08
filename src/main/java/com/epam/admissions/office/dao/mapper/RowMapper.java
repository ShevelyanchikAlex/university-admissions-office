package com.epam.admissions.office.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper interface.
 * For object mapping.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface RowMapper<T> {
    /**
     * Builds entity from resultSet
     *
     * @param resultSet resultSet
     * @return entity type
     * @throws SQLException sql exception
     */
    T map(ResultSet resultSet) throws SQLException;
}