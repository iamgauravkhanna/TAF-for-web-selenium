package listeners;

import constants.TestConstants;
import logger.TestLogger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.IExecutionListener;
import reporting.ExtentManager;
import utils.JavaUtil;

import java.io.File;

import static constants.TestConstants.SCREENSHOTS_PATH;

public class IExecutionListenerImpl implements IExecutionListener {

    @Override
    public void onExecutionStart() {

        String outputDirectory = System.getProperty("user.dir") + File.separator + "reports" + File.separator
                + "test-reports-" + JavaUtil.getCurrentTimeStamp();

        JavaUtil.createDirectory(outputDirectory);

        System.setProperty("logsDirectory", outputDirectory);

        JavaUtil.createDirectory(SCREENSHOTS_PATH);

        ExtentManager.getInstance();

        PropertyConfigurator.configure(TestConstants.LOG4J_PATH);

        TestLogger.INFO("Executed Started");
    }

    @Override
    public void onExecutionFinish() {
        TestLogger.INFO("TestNG has finished, took around");
        ExtentManager.getInstance().flush();
    }
}
