package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.FrameworkConstants.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        webDriver = driver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(EXPLICIT_WAIT));
    }

    public void openBrowser(String link) {
        try {
            webDriver.get(link);
            webDriver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("Page did not loaded within " + TIMEOUT + " seconds!");
        }
    }

    public WebElement waitForElementToBeClickable(By by) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void click(By by) {
        waitForElementToBeClickable(by).click();
    }
}
