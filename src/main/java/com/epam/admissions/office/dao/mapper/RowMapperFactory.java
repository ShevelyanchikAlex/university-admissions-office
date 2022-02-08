package com.epam.admissions.office.dao.mapper;

import com.epam.admissions.office.dao.mapper.impl.*;

/**
 * RowMapperFactory class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class RowMapperFactory {
    public static final UserRowMapper userRowMapper = new UserRowMapper();
    public static final FacultiesAdmissionInfoRowMapper facultiesAdmissionInfoRowMapper = new FacultiesAdmissionInfoRowMapper();
    public static final FacultiesHasSubjectsRowMapper facultiesHasSubjectsRowMapper = new FacultiesHasSubjectsRowMapper();
    public static final FacultyRowMapper facultyRowMapper = new FacultyRowMapper();
    public static final ResultRowMapper resultRowMapper = new ResultRowMapper();
    public static final ApplicationRowMapper applicationRowMapper = new ApplicationRowMapper();
    public static final SubjectRowMapper subjectRowMapper = new SubjectRowMapper();

    private RowMapperFactory() {
    }

    public static UserRowMapper getUserRowMapper() {
        return userRowMapper;
    }

    public static FacultiesAdmissionInfoRowMapper getFacultiesAdmissionInfoRowMapper() {
        return facultiesAdmissionInfoRowMapper;
    }

    public static FacultiesHasSubjectsRowMapper getFacultiesHasSubjectsRowMapper() {
        return facultiesHasSubjectsRowMapper;
    }

    public static FacultyRowMapper getFacultyRowMapper() {
        return facultyRowMapper;
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
