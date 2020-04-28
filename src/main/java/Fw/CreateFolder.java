package Fw;

import java.io.File;

public class CreateFolder {

    public static void createReportFolder(String path) {
        File reportDirectory = new File(path);
        if (!reportDirectory.exists()) {
            reportDirectory.mkdir();
        }
    }

}
