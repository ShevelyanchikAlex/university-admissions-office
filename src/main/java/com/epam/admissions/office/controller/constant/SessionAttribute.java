package com.epam.admissions.office.controller.constant;

/**
 * SessionAttribute class.
 * Contains session attributes.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public final class SessionAttribute {
    public static final String URL = "url";
    public static final String LOCALE = "locale";

    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_SURNAME = "user_surname";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_PASSPORT_ID = "user_passport_id";
    public static final String USER_ROLE = "user_role";

    public static final String APPLICATION = "application";
    public static final String POINTS_FIRST_SUBJECT = "points_first_subject";
    public static final String POINTS_SECOND_SUBJECT = "points_second_subject";
    public static final String POINTS_THIRD_SUBJECT = "points_third_subject";

    public static final String APPLICANTS = "applicants";
    public static final String ADMINISTRATORS = "administrators";
    public static final String NOT_RESPONDED_APPLICATIONS = "not_responded_applications";
    public static final String RESPONDED_APPLICATIONS = "responded_applications";
    public static final String ADMIN_TABLE = "admin_table";
    public static final String COUNT_OF_ADMINISTRATORS = "count_of_administrators";
    public static final String COUNT_OF_APPLICANTS = "count_of_applicants";
    public static final String COUNT_OF_APPLICATIONS = "count_of_applications";
    public static final String COUNT_OF_RESPONDED_APPLICATIONS = "count_of_responded_applications";

    public static final String FACULTIES_ADMISSION_INFO_LIST = "faculties_admission_info_list";

    public static final String INPUT_HINT_STATUS = "input_hint_status";

    private SessionAttribute() {
    }
}
