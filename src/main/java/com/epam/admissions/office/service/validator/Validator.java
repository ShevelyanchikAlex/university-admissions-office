package com.epam.admissions.office.service.validator;

public interface Validator<T> {
    boolean validate(T obj);
}
