package executors;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static util.configurations.TestConfiguration.DOWNLOAD_PATH;
import static util.helpers.FileHelper.*;

public class LoggedPage {

    private static final String FILE_NAME = "pgs_cv.jpg";

    public void verifyLoggedPageIsVisible() {
        $(By.cssSelector(".col-md-offset-5.col-md-7>a")).shouldBe(visible).shouldHave(text("Pobierz plik"));
    }

    public void clickLogoutLink() {
        $(By.id("logout")).click();
    }

    public void clickDownloadLink() {
        $(By.cssSelector(".col-md-offset-5.col-md-7>a")).click();
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
