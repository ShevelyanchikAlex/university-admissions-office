package com.epam.admissions.office.universityadmissionsoffice.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T map(ResultSet resultSet) throws SQLException;
}
