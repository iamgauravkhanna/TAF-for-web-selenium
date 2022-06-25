package constants;

import java.io.File;

public class TestConstants {

    public static final int EXPLICIT_WAIT = 10;
    public static final int FLUENT_WAIT = 30;
    public static final int FLUENT_POLLING = 5;
    public static final int TIMEOUT = 60;

    public static final String BROWSER_CHROME = "chrome";
    public static final String BROWSER_FIREFOX = "firefox";
    public static final String BROWSER_EDGE = "edge";
    public static final String BROWSER_OPERA = "opera";

    public static final String USER_DIR = System.getProperty("user.dir");

    public static final String DIRECTORY_ENV_CONFIG = "/src/main/resources/";

    public static final String LOGS_DIR = System.getProperty("logsDirectory");

    public static final String FILE_SEPARATOR = System.getProperty("file.separator");

    public static final String LOG4J_PATH = USER_DIR + FILE_SEPARATOR + "log4j.properties";

    public static final String SCREENSHOTS_PATH = LOGS_DIR + FILE_SEPARATOR + "screenshots";

    public static final String BASE_URL = "base.url";
}