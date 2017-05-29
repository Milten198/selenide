package util.helpers;


import com.codeborne.selenide.Configuration;
import org.apache.commons.io.FileUtils;
import util.configurations.TestConfiguration;

import java.io.File;
import java.io.IOException;

import static util.configurations.TestConfiguration.DOWNLOAD_PATH;

public class FileHelper {

    public static void cleanDirectory(String path) {
        try {
            if (new File(path).exists())
                FileUtils.cleanDirectory(new File(path));
        } catch (IOException e) {
            System.out.printf("Unable to clean directory: " + path, e);
        }
    }

    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirFiles = dir.listFiles();
        if (dirFiles != null) {
            for (File dirFile : dirFiles) {
                if (dirFile.getName().equals(fileName)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isFileNotCompleted() {
        boolean result = false;
        File folder = new File(DOWNLOAD_PATH);
        if (folder.exists() && folder.listFiles().length > 0) {
            for (int i = 0; i < folder.listFiles().length; i++) {
                String fileName = folder.listFiles()[i].getName();
                if (fileName.endsWith(".part") || fileName.endsWith(".crdownload") || fileName.endsWith(".tmp")) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }


    public static void waitForFileToBeDownloaded() throws InterruptedException {
        int counter = 0;
        while (counter < Configuration.timeout) {
            if (!isFileNotCompleted()) {
                break;
            } else {
                Thread.sleep(TestConfiguration.SHORT_TIME_FOR_THREAD);
                counter++;
            }
        }
    }
}
