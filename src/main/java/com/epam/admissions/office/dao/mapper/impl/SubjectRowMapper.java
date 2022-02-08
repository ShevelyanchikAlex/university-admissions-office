package com.epam.admissions.office.dao.mapper.impl;

import com.epam.admissions.office.dao.constant.DBColumn;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.entity.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * SubjectRowMapper class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class SubjectRowMapper implements RowMapper<Subject> {
    /**
     * {@inheritDoc}
     */
    @Override
    public Subject map(ResultSet resultSet) throws SQLException {
        Subject subject = new Subject();
        subject.setSubjectId(resultSet.getInt(DBColumn.SUBJECT_ID));
        subject.setSubjectName(resultSet.getString(DBColumn.SUBJECT_NAME));
        subject.setSubjectShortName(resultSet.getString(DBColumn.SUBJECT_SHORT_NAME));
        return subject;
    }
}
