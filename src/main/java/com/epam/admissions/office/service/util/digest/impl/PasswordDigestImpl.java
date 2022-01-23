package com.epam.admissions.office.service.util.digest.impl;

import com.epam.admissions.office.service.util.digest.PasswordDigest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordDigestImpl implements PasswordDigest {
    private static final String HASH_ALGORITHM = "SHA-256";

    @Override
    public String getDigestPassword(String password) {
        String digestPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);

            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16)
                        .substring(1));
            }
            digestPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return digestPassword;
    }
}
