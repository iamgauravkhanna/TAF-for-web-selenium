package screenshot;

import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static constants.TestConstants.FILE_SEPARATOR;
import static constants.TestConstants.SCREENSHOTS_PATH;

public class ScreenShotUtil {

    public static String takeScreenShot() {

        File screenShot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_hh-mm-ss-aa");

        String screenShotFile = dateFormat.format(new Date()) + ".png";

        try {
            FileUtils.copyFile(screenShot, new File(SCREENSHOTS_PATH + FILE_SEPARATOR + screenShotFile));
            return SCREENSHOTS_PATH + FILE_SEPARATOR + screenShotFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void takeScreenShotAsBase64() {
    }

    public static void takeScreenShotAsBytes() {
    }

}