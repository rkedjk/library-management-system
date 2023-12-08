/* ConfigurationManager.java */
package org.rsreu.library.resource;

import java.util.ResourceBundle;
import java.util.Locale;

public class ConfigurationManager {
    private final static ResourceBundle bundle = ResourceBundle.getBundle("config", Locale.getDefault());

    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return bundle.getString(key); // Use 'bundle' instead of 'resourceBundle'
    }
}
