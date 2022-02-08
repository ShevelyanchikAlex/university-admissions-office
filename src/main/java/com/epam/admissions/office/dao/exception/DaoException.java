package com.epam.admissions.office.dao.exception;

/**
 * DaoException class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class DaoException extends Exception {
    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
