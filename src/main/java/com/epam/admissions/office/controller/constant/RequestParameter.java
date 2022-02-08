package com.epam.admissions.office.controller.constant;

/**
 * RequestParameter class.
 * Contains request parameters.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public final class RequestParameter {
    public static final String COMMAND = "command";
    public static final String LOCALE = "locale";

    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_SURNAME = "user_surname";
    public static final String USER_PASSWORD = "user_password";
    public static final String CONFIRM_PASSWORD = "confirm_password";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_PASSPORT_ID = "user_passport_id";

    public static final String SELECTED_FACULTY_ID = "selected_faculty_id";
    public static final String SELECTED_FACULTY_SCORE = "selected_faculty_score";
    public static final String POINTS_FIRST_SUBJECT = "points_first_subject";
    public static final String POINTS_SECOND_SUBJECT = "points_second_subject";
    public static final String POINTS_THIRD_SUBJECT = "points_third_subject";

    public static final String APPLICATION_ID = "application_id";
    public static final String REJECTION_REASON = "rejection_reason";

    private RequestParameter() {
    }
}
