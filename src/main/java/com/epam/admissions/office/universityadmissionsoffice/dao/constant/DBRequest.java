package com.epam.admissions.office.universityadmissionsoffice.dao.constant;

public final class DBRequest {
    public final static String CREATE_USER_QUERY = String.format(
            "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s) VALUES (0, ?, ?, ?, ?, ?, ?, ?)",
            DBTable.USER_TABLE,
            DBColumn.USER_ID,
            DBColumn.USER_NAME,
            DBColumn.USER_SURNAME,
            DBColumn.USER_PASSWORD_HASH,
            DBColumn.USER_EMAIL,
            DBColumn.USER_PASSPORT_ID,
            DBColumn.USER_STATUS,
            DBColumn.USER_ROLE_ID);

    public final static String UPDATE_USER_QUERY = String.format(
            "UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?",
            DBTable.USER_TABLE,
            DBColumn.USER_NAME,
            DBColumn.USER_SURNAME,
            DBColumn.USER_PASSWORD_HASH,
            DBColumn.USER_EMAIL,
            DBColumn.USER_PASSPORT_ID,
            DBColumn.USER_STATUS,
            DBColumn.USER_ROLE_ID,
            DBColumn.USER_ID);

    public static final String GET_BY_ROLE_ID_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=?",
            DBTable.USER_TABLE,
            DBColumn.USER_ROLE_ID);

    public static final String GET_BY_ID_QUERY = "SELECT * FROM %s WHERE %s=?";

    public static final String GET_ALL_QUERY = String.format(
            "SELECT * FROM %s WHERE %s=ACTIVE",
            DBTable.USER_TABLE,
            DBColumn.USER_STATUS);

    public static final String DELETE_USER_QUERY = String.format(
            "UPDATE %s SET %s=DELETED WHERE %s=?",
            DBTable.USER_TABLE,
            DBColumn.USER_STATUS,
            DBColumn.USER_ID);

}
