package executors;

import locators.LoggedPageLocators;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static util.configurations.TestConfiguration.DOWNLOAD_PATH;
import static util.helpers.FileHelper.*;

public class LoggedPage {

    private LoggedPageLocators locators;

    public LoggedPage() {
        locators = new LoggedPageLocators();
    }

    private static final String FILE_NAME = "pgs_cv.jpg";

    public void verifyLoggedPageIsVisible() {
        locators.downloadLink.shouldBe(visible).shouldHave(text("Pobierz plik"));
    }

    public void clickLogoutLink() {
        locators.logoutLink.click();
    }

    public void clickDownloadLink() {
        locators.downloadLink.click();
    }

    public void cleanDownloadFolder() {
        cleanDirectory(DOWNLOAD_PATH);
    }

    public boolean checkIfFileWasDownloaded() {
        try {
            waitForFileToBeDownloaded();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isFileDownloaded(DOWNLOAD_PATH, FILE_NAME);
    }

}
