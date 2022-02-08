package com.epam.admissions.office.controller.constant;

/**
 * SessionAttributeValue class.
 * Contains session attribute values.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public final class SessionAttributeValue {
    public static final String CONTROLLER_COMMAND = "controller?command=";

    public static final String STATISTICS = "STATISTICS";
    public static final String APPLICATIONS_TABLE = "APPLICATIONS_TABLE";
    public static final String RESPONDED_APPLICATIONS_TABLE = "RESPONDED_APPLICATIONS_TABLE";
    public static final String ADMINISTRATORS_TABLE = "ADMINISTRATORS_TABLE";
    public static final String APPLICANTS_TABLE = "APPLICANTS_TABLE";

    public  static final int FIRST_SUBJECT_INDEX = 0;
    public  static final int SECOND_SUBJECT_INDEX = 1;
    public  static final int THIRD_SUBJECT_INDEX = 2;

    public static final String INPUT_HINT_SHOW = "SHOW";
    public static final String INPUT_HINT_HIDE = "HIDE";

    private SessionAttributeValue() {
    }
}
