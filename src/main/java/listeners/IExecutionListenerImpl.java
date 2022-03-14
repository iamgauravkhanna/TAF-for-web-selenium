package listeners;

import org.testng.IExecutionListener;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utils.JavaUtil;

import java.io.File;

public class IExecutionListenerImpl implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        System.out.println("TestNG has started, took around");
        System.setProperty("current.date.time", JavaUtil.getTimeStamp());

        String outputDirectory;
        outputDirectory = System.getProperty("user.dir") + File.separator + "reports" + File.separator
                + "test-reports-" + JavaUtil.getCurrentTimeStamp();
        JavaUtil.createDirectory(outputDirectory);
        System.setProperty("logsDirectory", outputDirectory);

        ExtentManager.getInstance();
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("TestNG has finished, took around");
        ExtentManager.getInstance().flush();
    }
}
