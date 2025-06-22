package StepDefinitions;

import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import utils.LogDirectoryInitializer;

import java.io.File;
import java.io.IOException;

public class Hooks {

    private static boolean initialized = false;

    @Before(order = 0)
    public void setupLogOnce() throws IOException {
        if (!initialized) {
            LogDirectoryInitializer.initLogFilePath();
//            cleanReportDir();
            initialized = true;
        }
    }

    //Clean file report when run cucumber
//    private void cleanReportDir() throws IOException {
//        File reportDir = new File("reports");
//        if (reportDir.exists()) {
//            FileUtils.deleteDirectory(reportDir);
//            System.out.println("Report folder cleaned: reports/");
//        }
//    }

}
