package com.epam.admissions.office.dao.mapper.impl;

import com.epam.admissions.office.dao.constant.DBColumn;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.entity.faculty.FacultyAdmissionInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultiesAdmissionInfoRowMapper implements RowMapper<FacultyAdmissionInfo> {
    @Override
    public FacultyAdmissionInfo map(ResultSet resultSet) throws SQLException {
        FacultyAdmissionInfo facultyAdmissionInfo = new FacultyAdmissionInfo();
        facultyAdmissionInfo.setFacultyId(resultSet.getInt(DBColumn.FACULTIES_ADMISSION_INFO_ID));
        facultyAdmissionInfo.setPassingScore(resultSet.getDouble(DBColumn.FACULTIES_ADMISSION_PASSING_SCORE));
        facultyAdmissionInfo.setPlaces(resultSet.getInt(DBColumn.FACULTIES_ADMISSION_PLACES));
        facultyAdmissionInfo.setYear(resultSet.getDate(DBColumn.FACULTIES_ADMISSION_YEAR));
        facultyAdmissionInfo.setFacultyId(resultSet.getInt(DBColumn.FACULTIES_ADMISSION_FACULTY_ID));
        return facultyAdmissionInfo;
    }
}
