package com.epam.admissions.office.service.util;

import com.epam.admissions.office.service.util.digest.PasswordDigest;
import com.epam.admissions.office.service.util.digest.impl.PasswordDigestImpl;

public class UtilFactory {
    private static final UtilFactory instance = new UtilFactory();

    private static final PasswordDigest passwordDigest = new PasswordDigestImpl();

    private UtilFactory() {
    }

    public static UtilFactory getInstance() {
        return instance;
    }

    public PasswordDigest getPasswordDigest() {
        return passwordDigest;
    }
}
