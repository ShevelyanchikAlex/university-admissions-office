package com.epam.admissions.office.dao.connection.exception;

/**
 * ConnectionPoolException class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class ConnectionPoolException extends Exception {
    public ConnectionPoolException() {
        super();
    }

    public ConnectionPoolException(String message) {
        super(message);
    }

    public ConnectionPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionPoolException(Throwable cause) {
        super(cause);
    }
}
