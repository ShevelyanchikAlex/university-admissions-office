package com.epam.admissions.office.service.util.mail;

import java.util.ResourceBundle;

public class MailResourceManager {
    private final String MAIL = "mail";

    private static final MailResourceManager instance = new MailResourceManager();

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle(MAIL);

    public static MailResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }
}
