package util;
import exception.DBConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBPropertyLoader {
    private static final String PROPERTIES_FILE = "db.properties";
    private static final Properties PROPERTIES = new Properties();

    private DBPropertyLoader() {}

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

        if(propertiesFile == null) {
            throw new DBConfigurationException("Properties file '" + PROPERTIES_FILE + "' missing!");
        }

        try {
            PROPERTIES.load(propertiesFile);
        } catch (IOException e) {
            throw new DBConfigurationException("Cannot load '" + PROPERTIES_FILE + "' file!");
        }
    }

    public static String getProperty(String key) {
//        String value = PROPERTIES.getProperty(key);
//        if(value == null || value.trim().length() == 0) {
//            throw new DBConfigurationException(
//                    "Required property '" + key + "' in properties file '" + PROPERTIES_FILE + "'!");
//        }
      //  return value;
        return "jdbc:mysql://localhost:3306/demo";
    }
}