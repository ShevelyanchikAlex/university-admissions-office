package com.epam.admissions.office.service.validator;

import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.service.validator.impl.PasswordValidator;
import com.epam.admissions.office.service.validator.impl.UserValidator;

public class ValidatorFactory {
    private static final ValidatorFactory instance = new ValidatorFactory();

    private static final Validator<User> userValidator = new UserValidator();
    private static final Validator<String> passwordValidator = new PasswordValidator();

    private ValidatorFactory() {
    }

    public static ValidatorFactory getInstance() {
        return instance;
    }

    public Validator<User> getUserValidator() {
        return userValidator;
    }

    public Validator<String> getPasswordValidator() {
        return passwordValidator;
    }
}
