package com.epam.admissions.office.dao.constant;

import java.sql.Date;

public final class DBRequest {
    //USER
    public final static String INSERT_USER_QUERY = String.format(
            "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s) VALUES (0, ?, ?, ?, ?, ?, ?, ?)",
            DBTable.USER_TABLE,
            DBColumn.USER_ID,
            DBColumn.USER_PASSWORD_HASH,
            DBColumn.USER_EMAIL,
            DBColumn.USER_NAME,
            DBColumn.USER_SURNAME,
            DBColumn.USER_PASSPORT_ID,
            DBColumn.USER_STATUS,
            DBColumn.USER_ROLE_ID);

    public final static String UPDATE_USER_QUERY = String.format(
            "UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?",
            DBTable.USER_TABLE,
            DBColumn.USER_PASSWORD_HASH,
            DBColumn.USER_EMAIL,
            DBColumn.USER_NAME,
            DBColumn.USER_SURNAME,
            DBColumn.USER_PASSPORT_ID,
            DBColumn.USER_STATUS,
            DBColumn.USER_ROLE_ID,
            DBColumn.USER_ID);

    public static final String GET_USER_BY_ID_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.USER_TABLE,
            DBColumn.USER_ID);

    public static final String GET_USER_BY_EMAIL_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.USER_TABLE,
            DBColumn.USER_EMAIL);

    public static final String GET_USER_BY_USER_ROLE_ID_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.USER_TABLE,
            DBColumn.USER_ROLE_ID);

    public static final String GET_ALL_USERS_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=ACTIVE",
            DBTable.USER_TABLE,
            DBColumn.USER_STATUS);

    public static final String DELETE_USER_QUERY = String.format(
            "UPDATE %s SET %s=DELETED WHERE %s=?",
            DBTable.USER_TABLE,
            DBColumn.USER_STATUS,
            DBColumn.USER_ID);

    public static final String COUNT_USERS_BY_ROLE_ID_QUERY = String.format(
            "SELECT COUNT(*) FROM %s WHERE %s=?",
            DBTable.USER_TABLE,
            DBColumn.USER_ROLE_ID);

    public static final String COUNT_ALL_USERS_QUERY = String.format(
            "SELECT COUNT(*) FROM %s",
            DBTable.USER_TABLE);

    public static final String RESTORE_USER_QUERY = String.format(
            "UPDATE %s SET %s=ACTIVE WHERE %s=?",
            DBTable.USER_TABLE,
            DBColumn.USER_STATUS,
            DBColumn.USER_ID);


    //Subject
    public final static String INSERT_SUBJECT_QUERY = String.format(
            "INSERT INTO %s (%s, %s, %s) VALUES (0, ?, ?)",
            DBTable.SUBJECT_TABLE,
            DBColumn.SUBJECT_ID,
            DBColumn.SUBJECT_NAME,
            DBColumn.SUBJECT_SHORT_NAME);

    public final static String UPDATE_SUBJECT_QUERY = String.format(
            "UPDATE %s SET %s=?, %s=? WHERE %s=?",
            DBTable.SUBJECT_TABLE,
            DBColumn.SUBJECT_NAME,
            DBColumn.SUBJECT_SHORT_NAME,
            DBColumn.SUBJECT_ID);

    public static final String GET_SUBJECT_BY_ID_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.SUBJECT_TABLE,
            DBColumn.SUBJECT_ID);

    public static final String DELETE_SUBJECT_QUERY = String.format(
            "DELETE FROM %s WHERE %s=?",
            DBTable.SUBJECT_TABLE,
            DBColumn.USER_ID);

    public static final String COUNT_ALL_SUBJECTS_QUERY = String.format(
            "SELECT COUNT(*) FROM %s",
            DBTable.SUBJECT_TABLE);

    public static final String GET_ALL_SUBJECTS_QUERY = String.format(
            "SELECT * FROM %s",
            DBTable.SUBJECT_TABLE);


    //Result
    public final static String INSERT_RESULT_QUERY = String.format(
            "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s) VALUES (0, ?, ?, ?, ?, ?, ?)",
            DBTable.RESULT_TABLE,
            DBColumn.RESULT_ID,
            DBColumn.RESULT_SCORE,
            DBColumn.RESULT_CERTIFICATE_ID,
            DBColumn.RESULT_CERTIFICATE_IMAGE_URL,
            DBColumn.RESULT_IS_CERTIFICATE_CONFIRMED,
            DBColumn.RESULT_APPLICATION_ID,
            DBColumn.RESULT_SUBJECT_ID);

    public final static String UPDATE_RESULT_QUERY = String.format(
            "UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?",
            DBTable.RESULT_TABLE,
            DBColumn.RESULT_SCORE,
            DBColumn.RESULT_CERTIFICATE_ID,
            DBColumn.RESULT_CERTIFICATE_IMAGE_URL,
            DBColumn.RESULT_IS_CERTIFICATE_CONFIRMED,
            DBColumn.RESULT_APPLICATION_ID,
            DBColumn.RESULT_SUBJECT_ID,
            DBColumn.RESULT_ID);

    public static final String GET_RESULT_BY_ID_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.RESULT_TABLE,
            DBColumn.RESULT_ID);

    public static final String GET_RESULTS_BY_SCORE_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.RESULT_TABLE,
            DBColumn.RESULT_SCORE);

    public static final String GET_RESULTS_BY_SUBJECT_ID_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.RESULT_TABLE,
            DBColumn.RESULT_SUBJECT_ID);

    public static final String DELETE_RESULT_QUERY = String.format(
            "DELETE FROM %s WHERE %s=?",
            DBTable.RESULT_TABLE,
            DBColumn.RESULT_ID);

    public static final String COUNT_ALL_RESULTS_QUERY = String.format(
            "SELECT COUNT(*) FROM %s",
            DBTable.RESULT_TABLE);

    public static final String GET_ALL_RESULTS_QUERY = String.format(
            "SELECT * FROM %s",
            DBTable.RESULT_TABLE);


    //Faculty
    public final static String INSERT_FACULTY_QUERY = String.format(
            "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (0, ?, ?, ?, ?)",
            DBTable.FACULTY_TABLE,
            DBColumn.FACULTY_ID,
            DBColumn.FACULTY_SHORT_NAME,
            DBColumn.FACULTY_NAME,
            DBColumn.FACULTY_DESCRIPTION,
            DBColumn.FACULTY_PICTURE_URL);

    public final static String UPDATE_FACULTY_QUERY = String.format(
            "UPDATE %s SET %s=?, %s=?, %s=?, %s=? WHERE %s=?",
            DBTable.FACULTY_TABLE,
            DBColumn.FACULTY_SHORT_NAME,
            DBColumn.FACULTY_NAME,
            DBColumn.FACULTY_DESCRIPTION,
            DBColumn.FACULTY_PICTURE_URL,
            DBColumn.FACULTY_ID);

    public static final String GET_FACULTY_BY_ID_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.FACULTY_TABLE,
            DBColumn.FACULTY_ID);


    public static final String DELETE_FACULTY_QUERY = String.format(
            "DELETE FROM %s WHERE %s=?",
            DBTable.FACULTY_TABLE,
            DBColumn.FACULTY_ID);

    public static final String COUNT_ALL_FACULTIES_QUERY = String.format(
            "SELECT COUNT(*) FROM %s",
            DBTable.FACULTY_TABLE);

    public static final String GET_ALL_FACULTIES_QUERY = String.format(
            "SELECT * FROM %s",
            DBTable.FACULTY_TABLE);


    //FacultyAdmissionInfo
    public final static String INSERT_FACULTY_ADMISSION_INFO_QUERY = String.format(
            "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (0, ?, ?, ?, ?)",
            DBTable.FACULTY_ADMISSION_INFO_TABLE,
            DBColumn.FACULTIES_ADMISSION_INFO_ID,
            DBColumn.FACULTIES_ADMISSION_PASSING_SCORE,
            DBColumn.FACULTIES_ADMISSION_PLACES,
            DBColumn.FACULTIES_ADMISSION_YEAR,
            DBColumn.FACULTIES_ADMISSION_FACULTY_ID);

    public final static String UPDATE_FACULTY_ADMISSION_INFO_QUERY = String.format(
            "UPDATE %s SET %s=?, %s=?, %s=?, %s=? WHERE %s=?",
            DBTable.FACULTY_ADMISSION_INFO_TABLE,
            DBColumn.FACULTIES_ADMISSION_PASSING_SCORE,
            DBColumn.FACULTIES_ADMISSION_PLACES,
            DBColumn.FACULTIES_ADMISSION_YEAR,
            DBColumn.FACULTIES_ADMISSION_FACULTY_ID,
            DBColumn.FACULTIES_ADMISSION_INFO_ID);

    public static final String GET_FACULTY_ADMISSION_INFO_BY_ID_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.FACULTY_ADMISSION_INFO_TABLE,
            DBColumn.FACULTIES_ADMISSION_INFO_ID);

    public static final String GET_FACULTY_ADMISSION_INFO_BY_FACULTY_ID_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.FACULTY_ADMISSION_INFO_TABLE,
            DBColumn.FACULTIES_ADMISSION_FACULTY_ID);

    public static final String DELETE_FACULTY_ADMISSION_INFO_QUERY = String.format(
            "DELETE FROM %s WHERE %s=?",
            DBTable.FACULTY_ADMISSION_INFO_TABLE,
            DBColumn.FACULTIES_ADMISSION_INFO_ID);

    public static final String COUNT_ALL_FACULTY_ADMISSION_INFOS_QUERY = String.format(
            "SELECT COUNT(*) FROM %s",
            DBTable.FACULTY_ADMISSION_INFO_TABLE);

    public static final String GET_ALL_FACULTY_ADMISSION_INFOS_QUERY = String.format(
            "SELECT * FROM %s",
            DBTable.FACULTY_ADMISSION_INFO_TABLE);

    public static final String GET_FACULTY_ADMISSION_INFOS_BY_PASSING_SCORE_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.FACULTY_ADMISSION_INFO_TABLE,
            DBColumn.FACULTIES_ADMISSION_PASSING_SCORE);

    public static final String GET_FACULTY_ADMISSION_INFOS_BY_PLACES_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.FACULTY_ADMISSION_INFO_TABLE,
            DBColumn.FACULTIES_ADMISSION_PLACES);


    //Application
    public final static String INSERT_APPLICATION_QUERY = String.format(
            "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s) VALUES (0, ?, ?, ?, ?, ?, ?)",
            DBTable.APPLICATION_TABLE,
            DBColumn.APPLICATION_ID,
            DBColumn.APPLICATION_APPLY_DATE,
            DBColumn.APPLICATION_IS_APPROVED,
            DBColumn.APPLICATION_DECISION_DATE,
            DBColumn.APPLICATION_REJECTION_REASON,
            DBColumn.APPLICATION_USER_ID,
            DBColumn.APPLICATION_FACULTY_ID);

    public final static String UPDATE_APPLICATION_QUERY = String.format(
            "UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?",
            DBTable.APPLICATION_TABLE,
            DBColumn.APPLICATION_APPLY_DATE,
            DBColumn.APPLICATION_IS_APPROVED,
            DBColumn.APPLICATION_DECISION_DATE,
            DBColumn.APPLICATION_REJECTION_REASON,
            DBColumn.APPLICATION_USER_ID,
            DBColumn.APPLICATION_FACULTY_ID,
            DBColumn.APPLICATION_ID);

    public static final String GET_APPLICATION_BY_ID_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.APPLICATION_TABLE,
            DBColumn.APPLICATION_ID);

    public static final String GET_APPLICATION_BY_USER_ID_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.APPLICATION_TABLE,
            DBColumn.APPLICATION_USER_ID);

    public static final String DELETE_APPLICATION_QUERY = String.format(
            "DELETE FROM %s WHERE %s=?",
            DBTable.APPLICATION_TABLE,
            DBColumn.APPLICATION_ID);

    public static final String COUNT_ALL_APPLICATIONS_QUERY = String.format(
            "SELECT COUNT(*) FROM %s",
            DBTable.FACULTY_ADMISSION_INFO_TABLE);

    public static final String GET_ALL_APPLICATIONS_QUERY = String.format(
            "SELECT * FROM %s",
            DBTable.APPLICATION_TABLE);

    public static final String GET_APPLICATIONS_BY_FACULTY_ID_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.APPLICATION_TABLE,
            DBColumn.APPLICATION_FACULTY_ID);

    public static final String GET_APPLICATIONS_BY_APPLY_DATE_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.APPLICATION_TABLE,
            DBColumn.APPLICATION_APPLY_DATE);

    public static final String GET_APPLICATIONS_BY_DECISION_DATE_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.APPLICATION_TABLE,
            DBColumn.APPLICATION_DECISION_DATE);


    private DBRequest() {
    }
}
