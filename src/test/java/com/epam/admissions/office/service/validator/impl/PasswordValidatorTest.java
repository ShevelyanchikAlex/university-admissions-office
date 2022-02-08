package com.epam.admissions.office.service.validator.impl;

import com.epam.admissions.office.service.validator.Validator;
import com.epam.admissions.office.service.validator.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    private final Validator<String> passwordValidator = ValidatorFactory.getInstance().getPasswordValidator();

    @Test
    void validateIncorrectLength() {
        boolean result = passwordValidator.validate("rwe");
        Assertions.assertFalse(result);
    }

    @Test
    void validateIncorrectData() {
        boolean result = passwordValidator.validate("rwe%4$");
        Assertions.assertFalse(result);
    }

    @Test
    void validateCorrectData() {
        boolean result = passwordValidator.validate("rtyasdCVB123");
        Assertions.assertTrue(result);
    }
}