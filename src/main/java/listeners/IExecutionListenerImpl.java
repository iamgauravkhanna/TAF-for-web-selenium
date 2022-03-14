package listeners;

import constants.FrameworkConstants;
import logger.CustomLog;
import org.apache.log4j.PropertyConfigurator;
import org.testng.IExecutionListener;
import reporting.ExtentManager;
import utils.JavaUtil;

import java.io.File;

public class IExecutionListenerImpl implements IExecutionListener {

    @Override
    public void onExecutionStart() {

        String outputDirectory;
        outputDirectory = System.getProperty("user.dir") + File.separator + "reports" + File.separator
                + "test-reports-" + JavaUtil.getCurrentTimeStamp();

        JavaUtil.createDirectory(outputDirectory);

        System.setProperty("logsDirectory", outputDirectory);

        ExtentManager.getInstance();

        System.out.println("Log4j Path : " + FrameworkConstants.log4jPath);
        PropertyConfigurator.configure(FrameworkConstants.log4jPath);
        CustomLog.INFO("Executed Started");
    }

    @Override
    public void onExecutionFinish() {
        CustomLog.INFO("TestNG has finished, took around");
        ExtentManager.getInstance().flush();
    }
}
