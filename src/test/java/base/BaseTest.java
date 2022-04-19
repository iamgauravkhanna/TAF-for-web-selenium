package base;

import driver.DriverManager;
import logger.TestLogger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        TestLogger.INFO("BEFORE TEST CASE : " + getClass().getSimpleName() + " WITH THREAD ID : " + Thread.currentThread().getId());
        DriverManager.setDriver(System.getProperty("browser"));
    }

    @AfterMethod
    public void afterMethod(){
        TestLogger.INFO("AFTER TEST CASE : " + getClass().getSimpleName() + " WITH THREAD ID : " + Thread.currentThread().getId());
        DriverManager.removeDriver();
    }
}
