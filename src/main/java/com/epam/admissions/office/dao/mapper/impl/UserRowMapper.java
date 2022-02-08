package com.epam.admissions.office.dao.mapper.impl;

import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.dao.constant.DBColumn;
import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserRowMapper class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class UserRowMapper implements RowMapper<User> {
    /**
     * {@inheritDoc}
     */
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt(DBColumn.USER_ID));
        user.setPasswordHash(resultSet.getString(DBColumn.USER_PASSWORD_HASH));
        user.setEmail(resultSet.getString(DBColumn.USER_EMAIL));
        user.setName(resultSet.getString(DBColumn.USER_NAME));
        user.setSurname(resultSet.getString(DBColumn.USER_SURNAME));
        user.setPassportId(resultSet.getString(DBColumn.USER_PASSPORT_ID));
        user.setDeleted(resultSet.getBoolean(DBColumn.USER_IS_DELETED));
        user.setUserRole(UserRole.values()[resultSet.getInt(DBColumn.USER_ROLE_ID)]);
        return user;
    }
}
