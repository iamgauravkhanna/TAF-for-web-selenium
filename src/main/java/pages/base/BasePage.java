package pages.base;

import driver.DriverManager;
import logger.TestLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
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
    protected FluentWait fluentWait;

    public BasePage() {
        webDriver = DriverManager.getDriver();
        PageFactory.initElements(webDriver, this);
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(EXPLICIT_WAIT));
    }

    public void openBrowser(String link) {
        try {
            webDriver.get(link);
            webDriver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            TestLogger.ERROR("Page did not loaded within " + TIMEOUT + " seconds!");
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
        String text = waitForElementVisibility(element).getText();
        TestLogger.INFO("Element Text : " + text);
        return text;
    }

    public void assertElementIsPresent(WebElement element) {
        if (element.isDisplayed()) {
            TestLogger.INFO_STEP("Element is Visible");
        } else {
            throw new ElementNotVisibleException("Element not visible");
        }
    }

    public void clearAndSendKeys(WebElement element, String value) {
        element = waitForElementVisibility(element);
        element.clear();
        element.sendKeys(value);
    }

    public void scrollToElement(WebElement element) {
        TestLogger.INFO("Scrolling to Element");
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getElementValue(WebElement element, String attribute) {
        String text = waitForElementVisibility(element).getAttribute(attribute);
        TestLogger.INFO("Attribute Value using " + attribute + " is : " + text);
        return text;
    }

    public String getElementElementCustomAttribute(WebElement element, String customAttribute) {
        return waitForElementVisibility(element).getAttribute(customAttribute);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public void highlightElement(WebElement element) {

        String highLightPropertyName = "outline";
        String highlightColor = "#00ff00 solid 3px";
        String originalColor = "none";

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        try {
            for (int i = 0; i < 5; i++) {
                js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + highlightColor + "'", element);
                Thread.sleep(50);
                js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + originalColor + "'", element);
                Thread.sleep(50);
                js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + highlightColor + "'", element);
                Thread.sleep(50);
                js.executeScript("arguments[0].style." + highLightPropertyName + " = '" + originalColor + "'", element);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement findElement(By locator) {
        WebElement element = waitForElementVisibility(webDriver.findElement(locator));
        highlightElement(element);
        return element;
    }

    public String getTagName(WebElement element) {
        String tagName = waitForElementVisibility(element).getTagName();
        TestLogger.INFO("Tag Name is : " + tagName);
        return tagName;
    }

    public Point getLocation(WebElement element) {
        TestLogger.INFO("Returning Location of Element");
        return waitForElementVisibility(element).getLocation();
    }

    public Dimension getSize(WebElement element) {
        TestLogger.INFO("Returning Size of Element");
        return waitForElementVisibility(element).getSize();
    }

}
