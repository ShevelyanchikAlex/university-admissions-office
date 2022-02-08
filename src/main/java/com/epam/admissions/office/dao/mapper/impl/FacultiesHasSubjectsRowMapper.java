package com.epam.admissions.office.dao.mapper.impl;

import com.epam.admissions.office.dao.constant.DBColumn;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.entity.faculty.FacultyHasSubject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * FacultiesHasSubjectsRowMapper class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class FacultiesHasSubjectsRowMapper implements RowMapper<FacultyHasSubject> {
    /**
     * {@inheritDoc}
     */
    @Override
    public FacultyHasSubject map(ResultSet resultSet) throws SQLException {
        FacultyHasSubject facultyHasSubject = new FacultyHasSubject();
        facultyHasSubject.setFacultyId(resultSet.getInt(DBColumn.FACULTY_ID));
        facultyHasSubject.setSubjectId(resultSet.getInt(DBColumn.SUBJECT_ID));
        facultyHasSubject.setYear(resultSet.getDate(DBColumn.FACULTY_HAS_SUBJECT_YEAR));
        return facultyHasSubject;
    }
}
