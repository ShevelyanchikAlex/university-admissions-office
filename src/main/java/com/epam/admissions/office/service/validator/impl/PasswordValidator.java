package com.epam.admissions.office.service.validator.impl;

import com.epam.admissions.office.service.validator.Validator;
import com.epam.admissions.office.service.validator.constant.ValidPattern;

import java.util.regex.Pattern;

public class PasswordValidator implements Validator<String> {
    @Override
    public boolean validate(String password) {
        return password != null && Pattern.compile(ValidPattern.PASSWORD_PATTERN).matcher(password).matches();
    }
}
