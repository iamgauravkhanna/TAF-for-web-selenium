package pages.project01;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HomePO extends BasePage {

    public static final String HOME_URL = "http://automationpractice.com";

    public HomePO(WebDriver webDriver){
        super(webDriver);
    }

    public void open(){
        openBrowser(HOME_URL);
    }
}