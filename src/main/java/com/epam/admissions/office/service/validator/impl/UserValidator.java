package com.epam.admissions.office.service.validator.impl;

import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.service.validator.Validator;
import com.epam.admissions.office.service.validator.constant.ValidPattern;

import java.util.regex.Pattern;

/**
 * UserValidator class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class UserValidator implements Validator<User> {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(User user) {
        return user != null &&
                user.getName() != null &&
                Pattern.compile(ValidPattern.NAME_PATTERN).matcher(user.getName()).matches() &&
                user.getSurname() != null &&
                Pattern.compile(ValidPattern.NAME_PATTERN).matcher(user.getSurname()).matches() &&
                user.getEmail() != null &&
                Pattern.compile(ValidPattern.EMAIL_PATTERN).matcher(user.getEmail()).matches() &&
                user.getPassportId() != null &&
                Pattern.compile(ValidPattern.PASSPORT_SERIES_AND_NUMBER).matcher(user.getPassportId()).matches();
    }
}
