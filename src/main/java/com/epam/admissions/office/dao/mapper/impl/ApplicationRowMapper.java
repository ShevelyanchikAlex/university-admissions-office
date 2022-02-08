package com.epam.admissions.office.dao.mapper.impl;

import com.epam.admissions.office.dao.constant.DBColumn;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.entity.Application;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ApplicationRowMapper class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class ApplicationRowMapper implements RowMapper<Application> {
    /**
     * {@inheritDoc}
     */
    @Override
    public Application map(ResultSet resultSet) throws SQLException {
        Application application = new Application();
        application.setApplicationId(resultSet.getInt(DBColumn.APPLICATION_ID));
        application.setApplyDate(resultSet.getDate(DBColumn.APPLICATION_APPLY_DATE));
        application.setApproved(resultSet.getBoolean(DBColumn.APPLICATION_IS_APPROVED));
        application.setDecisionDate(resultSet.getDate(DBColumn.APPLICATION_DECISION_DATE));
        application.setRejectionReason(resultSet.getString(DBColumn.APPLICATION_REJECTION_REASON));
        application.setUserId(resultSet.getInt(DBColumn.APPLICATION_USER_ID));
        application.setFacultyId(resultSet.getInt(DBColumn.APPLICATION_FACULTY_ID));
        return application;
    }
}
