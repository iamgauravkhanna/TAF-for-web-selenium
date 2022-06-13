package logger;

import org.apache.log4j.Logger;
import reporting.ExtentTestManager;
import utils.ConfigLoader;

public class TestLogger {

    private static Logger Log = Logger.getLogger("TestLogger");

    public static void INFO_STEP(String message) {
        INFO(message);
        if (ConfigLoader.getInstance().get("console.logs").equalsIgnoreCase("yes")) {
            System.out.println(" *** INFO : " + message);
        }
        if (ConfigLoader.getInstance().get("detailed.reporting").equalsIgnoreCase("yes")) {
            ExtentTestManager.getTest().info(message);
        }
    }

    public static void INFO(String message) {
        Log.info(message);
        if (ConfigLoader.getInstance().get("console.logs").equalsIgnoreCase("yes")) {
            System.out.println(" *** INFO : " + message);
        }
    }

    public static void ERROR(String message) {
        Log.error(message);
        System.out.println(" *** ERROR : " + message);
    }

}
