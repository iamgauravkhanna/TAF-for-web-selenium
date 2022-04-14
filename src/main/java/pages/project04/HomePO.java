package pages.project04;

import logger.MyLogger;
import pages.BasePage;
import utils.ConfigLoader;

public class HomePO extends BasePage {

    public static final String HOME_URL = ConfigLoader.getInstance().getPropertyValue("base.url");

    public void open(){
        MyLogger.infoExtentStep("Opening home page");
        openBrowser(HOME_URL);
    }
}