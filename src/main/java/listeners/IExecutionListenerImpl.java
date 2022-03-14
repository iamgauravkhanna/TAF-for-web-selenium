package listeners;

import org.testng.IExecutionListener;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

public class IExecutionListenerImpl implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        System.out.println("TestNG has started, took around");
        ExtentManager.getInstance();
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("TestNG has finished, took around");
        ExtentManager.getInstance().flush();
    }
}
