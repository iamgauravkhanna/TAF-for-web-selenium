package listeners;

import org.testng.IExecutionListener;

public class IExecutionListenerImpl implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        System.out.println("TestNG has started, took around");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("TestNG has finished, took around");
    }
}
