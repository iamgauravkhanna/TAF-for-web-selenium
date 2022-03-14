package logger;

import org.apache.log4j.Logger;
import reporting.ExtentTestManager;

public class CustomLog {

    // Initialize Log4j logs
    private static Logger Log = Logger.getLogger("CustomLog");

    public static void info(String message) {
        INFO(message);
        ExtentTestManager.getTest().info(message);
    }

    public static void INFO(String message) {
        Log.info(message);
        System.out.println(" *** INFO : " + message);
    }

}
