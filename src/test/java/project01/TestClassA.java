package project01;

import base.BaseTest;
import factory.DriverFactory;
import factory.PageFactoryManager;
import org.testng.annotations.Test;
import pages.project01.HomePO;

public class TestClassA extends BaseTest {

    @Test
    public void TestMethodA(){
        HomePO homePO;
        homePO = PageFactoryManager.getHomePO(DriverFactory.getDriver());
        homePO.open();
        homePO.goToSectionOne();
    }

    @Test
    public void TestMethodB(){
        HomePO homePO;
        homePO = PageFactoryManager.getHomePO(DriverFactory.getDriver());
        homePO.open();
    }

    @Test
    public void TestMethodC(){
        HomePO homePO;
        homePO = PageFactoryManager.getHomePO(DriverFactory.getDriver());
        homePO.open();
    }
}
