package com.epam.admissions.office.service.util.digest;

import com.epam.admissions.office.service.exception.ServiceException;

public interface PasswordDigest {
    String getDigestPassword(String password) throws ServiceException;
}
