package project01;

import base.BaseTest;
import factory.DriverFactory;
import factory.PageFactoryManager;
import org.testng.annotations.Test;
import pages.project01.HomePO;
import reporting.ExtentTestManager;

public class TestClassA extends BaseTest {

    @Test
    public void firstTestMethod(){
        HomePO homePO;
        homePO = PageFactoryManager.getHomePO(DriverFactory.getDriver());
        homePO.open();
        homePO.goToSectionOne();
        ExtentTestManager.getTest().pass("TC executed successfully");
    }
}