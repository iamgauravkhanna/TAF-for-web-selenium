package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import logger.MyLogger;
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
                    MyLogger.INFO("Creating Chrome Browser Instance");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case BROWSER_FIREFOX: {
                    MyLogger.INFO("Creating Firefox Browser Instance");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case BROWSER_SAFARI: {
                    driver = new SafariDriver();
                    break;
                }
                case BROWSER_EDGE: {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
                case BROWSER_OPERA: {
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                }
                default:
                    throw new IllegalStateException("INVALID BROWSER: " + browser);
            }
        }
        driver.manage().window().maximize();
        MyLogger.INFO("Returning new Driver with ID : " + driver.hashCode());
        return driver;
    }
}