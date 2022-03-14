package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtil {

    public static String getCurrentTimeStamp() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        Date date = new Date();
        return formatter.format(date);
    }
}
