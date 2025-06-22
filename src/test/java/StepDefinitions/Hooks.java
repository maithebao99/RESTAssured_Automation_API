package StepDefinitions;

import io.cucumber.java.Before;
import utils.LogDirectoryInitializer;
import utils.ReportFolderManager;

import java.io.IOException;

public class Hooks {

    private static boolean initialized = false;

    @Before(order = 0)
    public void setup() throws IOException {
        if (!initialized) {
            LogDirectoryInitializer.initLogFilePath(); // add file log to folder log
            ReportFolderManager.cleanReportFolder(); //clean report folder
            initialized = true;
        }
    }

}