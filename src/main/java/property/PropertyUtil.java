package property;

import logger.TestLogger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

    public static Properties propertyLoader(Properties properties, String filePath) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            try {
                //TestLogger.INFO("Loading Property : "+filePath);
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to load properties file " + filePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found at " + filePath);
        }
        return properties;
    }
}