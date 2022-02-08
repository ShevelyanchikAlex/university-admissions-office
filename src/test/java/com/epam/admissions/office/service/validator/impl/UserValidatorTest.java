package com.epam.admissions.office.service.validator.impl;

import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;
import com.epam.admissions.office.service.validator.Validator;
import com.epam.admissions.office.service.validator.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    private final Validator<User> userValidator = ValidatorFactory.getInstance().getUserValidator();

    @Test
    void validateEmptyUser() {
        boolean result = userValidator.validate(new User());
        Assertions.assertFalse(result);
    }

    @Test
    void validateIncorrectData() {
        boolean result = userValidator.validate(new User(9, "jf", "doff", "jfiejfei", "mail", "id", true, com.epam.admissions.office.entity.user.UserRole.USER));
        Assertions.assertFalse(result);
    }

    @Test
    void validateCorrectData() {
        boolean result = userValidator.validate(new User(0, "Alex", "Shevelyanchik", "qweSDFvbn123", "shevelyanchik_02@mail.ru", "AB5534433", false, UserRole.USER_WITHOUT_APPLICATION));
        Assertions.assertTrue(result);
    }
}