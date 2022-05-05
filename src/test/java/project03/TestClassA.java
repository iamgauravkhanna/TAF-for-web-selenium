package project03;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.project02.HomePage;

public class TestClassA extends BaseTest {

    @Test(description = "Test Cases #001")
    public void TestMethodA(){
        HomePage homePage = new HomePage();
        homePage.open();
    }
}