package org.rsreu.library.resource;

import java.util.ResourceBundle;
import java.util.Locale;

public class DatabaseManager {
    private final static ResourceBundle bundle = ResourceBundle.getBundle("database", Locale.getDefault());

    private DatabaseManager() {
    }

    public static String getProperty(String key) {
        return bundle.getString(key);
    }
}
