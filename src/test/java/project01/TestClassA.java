package project01;

import base.BaseTest;
import factory.DriverFactory;
import factory.PageFactoryManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.project01.HomePO;
import reporting.ExtentTestManager;

public class TestClassA extends BaseTest {

    @Test(description = "Test Cases #001")
    public void TestMethodA(){
        HomePO homePO;
        homePO = PageFactoryManager.getHomePO(DriverFactory.getDriver());
        homePO.open();
        homePO.goToSectionOne();
    }

    @Test(description = "Test Cases #002")
    public void TestMethodB(){
        Assert.assertEquals(7,9);
    }

    @Test(description = "Test Cases #003", dependsOnMethods = "TestMethodB")
    public void TestMethodC(){
        Assert.assertEquals(7,7);
    }


}