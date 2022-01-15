package com.epam.admissions.office.universityadmissionsoffice.dao.mapper.impl;



import com.epam.admissions.office.universityadmissionsoffice.dao.constant.DBColumn;
import com.epam.admissions.office.universityadmissionsoffice.dao.mapper.RowMapper;
import com.epam.admissions.office.universityadmissionsoffice.entity.Result;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultRowMapper implements RowMapper<Result> {
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
