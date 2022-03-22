package constants;

import java.io.File;

public class TestConstants {

    public static final int EXPLICIT_WAIT = 10;
    public static final int FLUENT_WAIT = 30;
    public static final int FLUENT_POLLING = 5;
    public static final int TIMEOUT = 60;

    /* SUPPORTED BROWSERS */
    public static final String BROWSER_CHROME = "chrome";
    public static final String BROWSER_FIREFOX = "firefox";
    public static final String BROWSER_SAFARI = "safari";
    public static final String BROWSER_EDGE = "edge";
    public static final String BROWSER_OPERA = "opera";

    public static final String DIRECTORY_ENV_CONFIG = "/src/main/resources/";

    public static final String ATTRIBUTE_VALUE = "value";

    public static final String log4jPath = System.getProperty("user.dir") + File.separator + "log4j.properties";
}
