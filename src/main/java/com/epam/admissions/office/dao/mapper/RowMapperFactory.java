package com.epam.admissions.office.dao.mapper;


import com.epam.admissions.office.dao.mapper.impl.ApplicationRowMapper;
import com.epam.admissions.office.dao.mapper.impl.SubjectRowMapper;
import com.epam.admissions.office.dao.mapper.impl.UserRowMapper;
import com.epam.admissions.office.dao.mapper.impl.ResultRowMapper;

public class RowMapperFactory {
    public static final UserRowMapper userRowMapper = new UserRowMapper();
    public static final ApplicationRowMapper applicationRowMapper = new ApplicationRowMapper();
    public static final ResultRowMapper resultRowMapper = new ResultRowMapper();
    public static final SubjectRowMapper subjectRowMapper = new SubjectRowMapper();

    public static UserRowMapper getUserRowMapper() {
        return userRowMapper;
    }

    public static ApplicationRowMapper getApplicationRowMapper() {
        return applicationRowMapper;
    }

    public static ResultRowMapper getResultRowMapper() {
        return resultRowMapper;
    }

    public static SubjectRowMapper getSubjectRowMapper() {
        return subjectRowMapper;
    }


}
