package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ReportFolderManager {

    private static final String BASE_REPORTS_PATH = "reports";

    public static void cleanReportFolder() throws IOException {
        File reportsDir = new File(BASE_REPORTS_PATH);

        if (reportsDir.exists()) {
            try {
                FileUtils.deleteDirectory(reportsDir);
                System.out.println("Deleted report folder: " + reportsDir.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Failed to delete report folder: " + reportsDir.getAbsolutePath());
                e.printStackTrace();
                throw e;
            }
        } else {
            System.out.println("Report folder not found. Skipping deletion.");
        }
    }
}
