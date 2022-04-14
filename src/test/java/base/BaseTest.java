package base;

import driver.DriverManager;
import logger.MyLogger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        MyLogger.INFO("BEFORE TEST CASE : " + getClass().getSimpleName() + " WITH THREAD ID : " + Thread.currentThread().getId());
        DriverManager.setDriver(System.getProperty("browser"));
    }

    @AfterMethod
    public void afterMethod(){
        MyLogger.INFO("AFTER TEST CASE : " + getClass().getSimpleName() + " WITH THREAD ID : " + Thread.currentThread().getId());
        DriverManager.removeDriver();
    }
}
