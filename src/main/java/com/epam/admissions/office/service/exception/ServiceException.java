package com.epam.admissions.office.service.exception;

/**
 * ServiceException class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class ServiceException extends Exception {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
