package driver;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    protected static ThreadLocal<WebDriver> threadLocal =  new ThreadLocal<WebDriver>();

    public static void setDriver(String browserType) {
        WebDriver driver = BrowserFactory.createDriverInstance(browserType);
        threadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public static void removeDriver() {
        getDriver().quit();
        threadLocal.remove();
    }
}
