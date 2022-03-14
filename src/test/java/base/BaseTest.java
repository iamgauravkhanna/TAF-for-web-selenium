package base;

import factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import reporting.ExtentTestManager;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("BEFORE TEST CASE : " + getClass().getSimpleName() + " WITH THREAD ID : " + Thread.currentThread().getId());
        DriverFactory.setDriver("firefox");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AFTER TEST CASE : " + getClass().getSimpleName() + " WITH THREAD ID : " + Thread.currentThread().getId());
        DriverFactory.removeDriver();
    }
}
