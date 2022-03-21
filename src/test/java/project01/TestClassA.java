package project01;

import base.BaseTest;
import driver.DriverManager;
import factory.PageFactoryManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.project01.HomePO;

public class TestClassA extends BaseTest {

    @Test(description = "Test Cases #001")
    public void TestMethodA(){
        HomePO homePO;
        homePO = PageFactoryManager.getHomePO(DriverManager.getDriver());
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