package com.epam.admissions.office.service.validator;

/**
 * Validator interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface Validator<T> {
    /**
     * Validate entity
     *
     * @param obj entity
     * @return true if valid, otherwise false
     */
    boolean validate(T obj);
}
