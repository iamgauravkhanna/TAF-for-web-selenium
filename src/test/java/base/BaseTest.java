package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId());

    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId());
    }
}
