package project01;

import factory.PageFactoryManager;
import org.testng.annotations.Test;
import pages.project01.HomePO;

public class TestClassA {

    @Test
    public void TestMethodA(){
        HomePO homePO;
        homePO = PageFactoryManager.getHomePO();
        homePO.open();
    }
}
