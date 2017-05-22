package executors;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    public void openTask(String taskNumber) {
        open("https://testingcup.pgs-soft.com");
        if (taskNumber.equals("6")) {
            $(By.xpath(String.format("//a[@href = '/task_%s/logged']", taskNumber))).click();
        } else {
            $(By.xpath(String.format("//a[@href = '/task_%s']", taskNumber))).click();
        }

    }
}
