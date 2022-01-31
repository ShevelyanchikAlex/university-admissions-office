package com.epam.admissions.office.controller.constant;

import java.sql.Date;

public final class SessionAttribute {
    public static final String URL = "url";
    public static final String LOCALE = "locale";

    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_SURNAME = "user_surname";
    public static final String USER_PASSWORD = "user_password";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_PASSPORT_ID = "user_passport_id";
    public static final String USER_IS_DELETED = "user_is_deleted";
    public static final String USER_ROLE = "user_role";


    public static final String SELECTED_APPLICATION = "selected_application";

    public static final String APPLICATION = "application";
    public static final String APPLICATION_ID = "application_id";
    public static final String APPLICATION_APPLY_DATE = "application_apply_date";
    public static final String APPLICATION_IS_APPROVED = "application_is_approved";
    public static final String APPLICATION_DECISION_DATE = "application_decision_date";
    public static final String APPLICATION_REJECTION_REASON = "application_rejection_reason";
    public static final String APPLICATION_FACULTY_ID = "application_faculty_id";

    public static final String POINTS_FIRST_SUBJECT = "points_first_subject";
    public static final String POINTS_SECOND_SUBJECT = "points_second_subject";
    public static final String POINTS_THIRD_SUBJECT = "points_third_subject";


    public static final String FACULTY_ID = "faculty_id";

    public static final String APPLICANTS = "applicants";
    public static final String ADMINISTRATORS = "administrators";
    public static final String NOT_RESPONDED_APPLICATIONS = "not_responded_applications";
    public static final String RESPONDED_APPLICATIONS = "responded_applications";

    public static final String ERROR = "error";

    public static final String ADMIN_TABLE = "admin_table";

    private SessionAttribute() {
    }
}
