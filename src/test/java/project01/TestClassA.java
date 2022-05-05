package project01;

import base.BaseTest;
import factory.PageFactoryManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.project01.HomePage;

public class TestClassA extends BaseTest {

    @Test(description = "Test Cases #001")
    public void TestMethodA(){
        HomePage homePage = PageFactoryManager.getHomePage();
        homePage.open();
        homePage.goToSectionOne();
    }

    @Test(description = "Test Cases #002", enabled = false)
    public void TestMethodB(){
        Assert.assertEquals(7,9);
    }

    @Test(description = "Test Cases #003", dependsOnMethods = "TestMethodB",enabled = false)
    public void TestMethodC(){
        Assert.assertEquals(7,7);
    }

}