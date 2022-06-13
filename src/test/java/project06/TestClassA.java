package project06;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.project06.HomePage;

public class TestClassA extends BaseTest {

    @Test(description = "Test Cases #001")
    public void TestMethodA(){
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.signIn();
    }

}