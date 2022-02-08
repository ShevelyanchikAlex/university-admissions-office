package com.epam.admissions.office.service.util.digest;

import com.epam.admissions.office.service.exception.ServiceException;

/**
 * PasswordDigest interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface PasswordDigest {
    /**
     * Get digest from string
     *
     * @param password password
     * @return digest
     * @throws ServiceException if an exception is thrown while working on service layer
     */
    String getDigestPassword(String password) throws ServiceException;
}
