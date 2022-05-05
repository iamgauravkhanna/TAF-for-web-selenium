package pages.project04;

import constants.TestConstants;
import logger.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import utils.ConfigLoader;
import utils.JavaUtil;

public class HomePage extends BasePage {

    @FindBy(id = "file-upload")
    private WebElement fileUpload;

    @FindBy(id = "file-submit")
    private WebElement uploadButton;

    public void open() {
        TestLogger.INFO_STEP("Opening home page");
        openBrowser(ConfigLoader.getInstance().get(TestConstants.BASE_PATH));
    }

    public void uploadFile() {
        goToPage(ConfigLoader.getInstance().get(TestConstants.BASE_PATH) + "/upload");
        uploadFile(fileUpload, TestConstants.LOG4J_PATH);
        click(uploadButton);
        pause();
        waitForElementVisibility(findElement(By.xpath("//h3[text()='File Uploaded!']")));
    }
}