package com.epam.admissions.office.dao.mapper.impl;

import com.epam.admissions.office.dao.constant.DBColumn;
import com.epam.admissions.office.dao.mapper.RowMapper;
import com.epam.admissions.office.entity.Result;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ResultRowMapper class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class ResultRowMapper implements RowMapper<Result> {
    /**
     * {@inheritDoc}
     */
    @Override
    public Result map(ResultSet resultSet) throws SQLException {
        Result result = new Result();
        result.setResultId(resultSet.getInt(DBColumn.RESULT_ID));
        result.setScore(resultSet.getInt(DBColumn.RESULT_SCORE));
        result.setCertificateId(resultSet.getInt(DBColumn.RESULT_CERTIFICATE_ID));
        result.setCertificateImageUrl(resultSet.getString(DBColumn.RESULT_CERTIFICATE_IMAGE_URL));
        result.setCertificateConfirmed(resultSet.getBoolean(DBColumn.RESULT_IS_CERTIFICATE_CONFIRMED));
        result.setApplicationId(resultSet.getInt(DBColumn.RESULT_APPLICATION_ID));
        result.setSubjectId(resultSet.getInt(DBColumn.RESULT_SUBJECT_ID));
        return result;
    }
}
