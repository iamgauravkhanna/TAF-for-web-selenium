package logger;

import constants.FrameworkConstants;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import reporting.ExtentTestManager;

public class CustomLog {

    private static Logger Log = Logger.getLogger("CustomLog");

    public static void infoExtentStep(String message) {
        INFO(message);
        ExtentTestManager.getTest().info(message);
    }

    public static void INFO(String message) {
        Log.info(message);
        System.out.println(" *** INFO : " + message);
    }

}
