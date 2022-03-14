package listeners;

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

        String log4jPath = System.getProperty("user.dir") + File.separator + "/" + "log4j.properties";
        PropertyConfigurator.configure(log4jPath);

    }

    @Override
    public void onExecutionFinish() {
        System.out.println("TestNG has finished, took around");
        ExtentManager.getInstance().flush();
    }
}
