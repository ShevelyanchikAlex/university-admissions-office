package com.epam.admissions.office.dao.mapper.impl;

import com.epam.admissions.office.dao.constant.DBColumn;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.entity.faculty.Faculty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyRowMapper implements RowMapper<Faculty> {
    @Override
    public Faculty map(ResultSet resultSet) throws SQLException {
        Faculty faculty = new Faculty();
        faculty.setFacultyId(resultSet.getInt(DBColumn.FACULTY_ID));
        faculty.setFacultyShortName(resultSet.getString(DBColumn.FACULTY_SHORT_NAME));
        faculty.setFacultyName(resultSet.getString(DBColumn.FACULTY_NAME));
        faculty.setFacultyDescription(resultSet.getString(DBColumn.FACULTY_DESCRIPTION));
        faculty.setLogoPictureUrl(resultSet.getString(DBColumn.FACULTY_PICTURE_URL));
        return faculty;
    }
}
