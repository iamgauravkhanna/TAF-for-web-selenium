package logger;

import org.apache.log4j.Logger;
import reporting.ExtentTestManager;

public class TestLogger {

    private static Logger Log = Logger.getLogger("TestLogger");

    public static void INFO_STEP(String message) {
        INFO(message);
        ExtentTestManager.getTest().info(message);
    }

    public static void INFO(String message) {
        Log.info(message);
        System.out.println(" *** INFO : " + message);
    }

    public static void ERROR(String message) {
        Log.error(message);
        System.out.println(" *** ERROR : " + message);
    }

}
