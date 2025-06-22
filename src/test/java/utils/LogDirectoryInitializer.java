package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogDirectoryInitializer {

    public static void initLogFilePath() {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String folder = "logs/test-logs";
        String fileName = "cucumber-" + timestamp + ".log";

        new File(folder).mkdirs(); // add folder if it does not exit

        System.setProperty("LOG_FILE", folder + "/" + fileName);
    }
}
