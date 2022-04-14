package project03;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.project02.HomePO;

public class TestClassA extends BaseTest {

    @Test(description = "Test Cases #001")
    public void TestMethodA(){
        HomePO homePO = new HomePO();
        homePO.open();
    }
}