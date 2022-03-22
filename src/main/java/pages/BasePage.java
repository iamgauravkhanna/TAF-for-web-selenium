package pages;

import logger.MyLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.TestConstants.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected FluentWait fluentWait ;

    public BasePage(WebDriver driver) {
        webDriver = driver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(EXPLICIT_WAIT));
    }

    public void openBrowser(String link) {
        try {
            webDriver.get(link);
            webDriver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            MyLogger.ERROR("Page did not loaded within " + TIMEOUT + " seconds!");
        }
    }

    public void waitForOverlaysToDisappear(By overlay) {
        List<WebElement> overlays = webDriver.findElements(overlay);
        System.out.println("OVERLAY SIZE" + overlays.size());
        if (overlays.size() > 0) {
            webDriverWait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAYS INVISIBLE");
        } else {
            System.out.println("OVERLAY NOT FOUND");
        }
    }

    public WebElement waitForElementToBeClickable(By by) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForElementVisibility(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(By by) {
        waitForElementToBeClickable(by).click();
    }

    public String getElementText(WebElement element) {
        return waitForElementVisibility(element).getText();
    }

    public void clearAndSendKeys(WebElement element, String value) {
        element = waitForElementVisibility(element);
        element.clear();
        element.sendKeys(value);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getElementElementAttribute_Value(WebElement element) {
        return waitForElementVisibility(element).getAttribute(ATTRIBUTE_VALUE);
    }

    public String getElementElementCustomAttribute(WebElement element, String customAttribute) {
        return waitForElementVisibility(element).getAttribute(customAttribute);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

}
