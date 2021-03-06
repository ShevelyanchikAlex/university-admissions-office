package com.epam.admissions.office.dao.connection;

import java.util.ResourceBundle;

/**
 * DBResourceManager class.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class DBResourceManager {
    private final String DB = "db";

    private static final DBResourceManager instance = new DBResourceManager();

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle(DB);

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }
}
