package com.epam.admissions.office.service.validator.constant;

public final class ValidPattern {
    public static final String NAME_PATTERN = "^([А-Я][а-яё]{1,49}|[A-Z][a-z]{1,49})$";
    public static final String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,30}$";
    public static final String PASSPORT_SERIES_AND_NUMBER = "^[A-Z]{2}[0-9]{7}$";

    private ValidPattern() {
    }
}
