package com.epam.admissions.office.dao.mapper.impl;

import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.dao.constant.DBColumn;
import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;
import com.epam.admissions.office.entity.user.UserStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt(DBColumn.USER_ID));
        user.setPasswordHash(resultSet.getString(DBColumn.USER_PASSWORD_HASH));
        user.setEmail(resultSet.getString(DBColumn.USER_EMAIL));
        user.setName(resultSet.getString(DBColumn.USER_NAME));
        user.setSurname(resultSet.getString(DBColumn.USER_SURNAME));
        user.setPassportId(resultSet.getString(DBColumn.USER_PASSPORT_ID));
        user.setUserStatus(UserStatus.valueOf(resultSet.getString(DBColumn.USER_STATUS)));
        user.setUserRole(UserRole.valueOf(resultSet.getString(DBColumn.ROLE_NAME).toUpperCase()));
        return user;
    }
}