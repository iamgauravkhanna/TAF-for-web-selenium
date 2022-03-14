package utils;

import property.PropertyUtil;

import java.io.File;
import java.util.Properties;

import static constants.FrameworkConstants.DIRECTORY_ENV_CONFIG;

/**
 * Singleton Design Pattern is implemented here
 */
public class ConfigLoader {

    private Properties properties;

    private static ConfigLoader configLoader;

    private ConfigLoader() {

        String testEnvironment = System.getProperty("testEnvironment") ;

        String resourcePath = System.getProperty("user.dir") + DIRECTORY_ENV_CONFIG + testEnvironment + File.separator;

        File directoryPath = new File(resourcePath);

        File[] filesList = directoryPath.listFiles();

        for(File file : filesList) {
            properties = PropertyUtil.propertyLoader(resourcePath + file.getName());
        }
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }


    public String getPropertyValue(String propertyKey) {
        String prop = properties.getProperty(propertyKey);
        if (prop != null) {
            return prop.trim();
        } else {
            throw new RuntimeException("Property " + propertyKey + " is not specified in the config.properties file");
        }
    }


}
