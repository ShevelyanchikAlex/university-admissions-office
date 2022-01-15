package com.epam.admissions.office.universityadmissionsoffice.dao.constant;

public final class DBColumn {

    public static final String ROLE_ID = "role_id";
    public static final String ROLE_NAME = "role_name";

    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_PASSWORD_HASH = "password";
    public static final String USER_EMAIL = "email";
    public static final String USER_PASSPORT_ID = "passport_id";
    public static final String USER_STATUS = "status";
    public static final String USER_ROLE_ID = "role_id";


    public static final String APPLICATION_ID = "application_id";
    public static final String APPLICATION_APPLY_DATE = "apply_date";
    public static final String APPLICATION_IS_APPROVED = "is_approved";
    public static final String APPLICATION_DECISION_DATE = "decision_date";
    public static final String APPLICATION_REJECTION_REASON = "rejection_reason";
    public static final String APPLICATION_USER_ID = "user_id";
    public static final String APPLICATION_FACULTY_ID = "faculty_id";


    public static final String RESULT_ID = "result_id";
    public static final String RESULT_SCORE = "score";
    public static final String RESULT_CERTIFICATE_ID = "certificate_id";
    public static final String RESULT_CERTIFICATE_IMAGE_URL = "certificate_image_url";
    public static final String RESULT_IS_CERTIFICATE_CONFIRMED = "is_certificate_confirmed";
    public static final String RESULT_APPLICATION_ID = "application_id";
    public static final String RESULT_SUBJECT_ID = "subject_id";

    public static final String SUBJECT_ID = "subject_id";
    public static final String SUBJECT_NAME = "subject_name";
    public static final String SUBJECT_SHORT_NAME = "subject_short_name";


    private DBColumn() {
    }
}
