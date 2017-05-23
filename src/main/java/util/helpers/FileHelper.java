package util.helpers;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileHelper {

    public static void cleanDirectory(String path) {
        try {
            if (new File(path).exists())
                FileUtils.cleanDirectory(new File(path));
        } catch (IOException e) {
            System.out.printf("Unable to clean directory: " + path, e);
        }
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
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
}
