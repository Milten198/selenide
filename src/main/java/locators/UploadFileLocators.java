package locators;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class UploadFileLocators {

    public SelenideElement uploadButton = $(".btn.btn-primary.btn-block.btn-file>input");
    public SelenideElement tableBody = $("tbody");
    public List<SelenideElement> rowsNumber = $$(By.xpath("//tbody/tr"));

    public List<SelenideElement> getRecordsFromRow(int row) {
        return $$(By.xpath(String.format("//tr[%s]/td", row)));
    }
}
