package com.epam.admissions.office.controller.constant;

public final class SessionAttributeValue {
    public static final String CONTROLLER_COMMAND = "controller?command=";
    public static final String LOCALE_EN = "en";
    public static final String LOCALE_RU = "ru";


    public static final String ALERT_MESSAGE_INCORRECT_EMAIL_EN = "User with this email already exists, please use another email.";
    public static final String ALERT_MESSAGE_INCORRECT_EMAIL_RU = "Пользователь с таким email уже существует, используйте другой email.";
    public static final String ALERT_MESSAGE_INCORRECT_DATA_EN = "You have entered incorrect data.\nFirst- and lastname must contain only letters.\nThe email must be entered correctly (for example university@gmail.com).\nPassport data must contain a series (2 letters) and a number (7 digits) of the passport (for example AB1112233).\\nThe password must have at least 1 uppercase and 1 lowercase letter, 1 number and be at least 8 characters long.";
    public static final String ALERT_MESSAGE_INCORRECT_DATA_RU = "Вами были некорректно введены данные.\nИмя и фамилия должны содержать только буквы.\nEmail должен быть введен корректно(например university@gmail.com).\nПаспортные данные должны содержать серию(2 буквы) и номер(7 цифр) паспорта (AB1112233).\nПароль должен иметь хотя бы 1 заглавную и 1 прописную букву, 1 цифру и быть не короче 8 символов.";

    public static final String ALERT_MESSAGE_INCORRECT_LOGIN_DATA_EN = "Incorrect email or password entered.\r\nPlease try again.";
    public static final String ALERT_MESSAGE_INCORRECT_LOGIN_DATA_RU = "Неверно введен email или пароль.\r\nПовторите попытку еще раз.";

    public static final String APPLICATIONS_TABLE = "APPLICATIONS_TABLE";
    public static final String RESPONDED_APPLICATIONS_TABLE = "RESPONDED_APPLICATIONS_TABLE";
    public static final String ADMINISTRATORS_TABLE = "ADMINISTRATORS_TABLE";
    public static final String APPLICANTS_TABLE = "APPLICANTS_TABLE";

    private SessionAttributeValue() {
    }
}
