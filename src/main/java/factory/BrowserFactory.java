package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import logger.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import static constants.TestConstants.*;

public class BrowserFactory {

    public static WebDriver createDriverInstance(String browser) {

        WebDriver driver = null;

        if (System.getProperty("executionEnvironment").equalsIgnoreCase("local")) {
            switch (browser) {
                case BROWSER_CHROME: {
                    TestLogger.INFO("Creating Chrome Browser Instance");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case BROWSER_FIREFOX: {
                    TestLogger.INFO("Creating Firefox Browser Instance");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case BROWSER_EDGE: {
                    TestLogger.INFO("Creating Edge Browser Instance");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
                case BROWSER_OPERA: {
                    TestLogger.INFO("Creating Opera Browser Instance");
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                }
                default:
                    throw new IllegalStateException("INVALID BROWSER: " + browser);
            }
        }
        driver.manage().window().maximize();
        TestLogger.INFO("Returning new Driver - ID : " + driver.hashCode());
        return driver;
    }
}