package executors;

import org.openqa.selenium.By;
import util.FileHelper;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoggedPage {

    private FileHelper fileHelper;

    public LoggedPage() {
        fileHelper = new FileHelper();
    }

    private static final String DOWNLOAD_PATH = "D:\\Selenide\\proj\\downloads";
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
        FileHelper.cleanDirectory(DOWNLOAD_PATH);
    }

    public boolean checkIfFileWasDownloaded() {
        return fileHelper.isFileDownloaded(DOWNLOAD_PATH, FILE_NAME);
    }
}
