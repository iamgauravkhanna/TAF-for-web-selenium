package pages.project06;

import constants.TestConstants;
import logger.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import utils.ConfigLoader;

public class HomePage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public void open() {
        TestLogger.INFO_STEP("Opening home page");
        openBrowser(ConfigLoader.getInstance().get(TestConstants.BASE_URL));
    }

    public void signIn() {
        sendKeys(username, "standard_user");
        pause();
        sendKeys(password, "secret_sauce");
        pause();
        loginBtn.click();
        pause();
        waitForElementVisibility(findElement(By.xpath("//*[text()='Products']")));
    }
}