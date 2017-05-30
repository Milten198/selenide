package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PopUpFormWindowLocators {

    public SelenideElement frame = $(By.xpath("//iframe"));
    public SelenideElement saveButton = $("#save-btn");
    public SelenideElement name = $(By.xpath("//input[@name='name']"));
    public SelenideElement email = $(By.xpath("//input[@name='email']"));
    public SelenideElement phone = $(By.xpath("//input[@name='phone']"));
    public SelenideElement confirmationMessage = $(".container>h1");

    public By formFieldLocator(FormFields field) {
        return By.xpath(String.format("(//span[@class='error'])[%s]", field.fieldNumber));
    }

    public enum FormFields {
        EMAIL("1"),
        PHONE("2");

        String fieldNumber;

        FormFields(String fieldNumber) {
            this.fieldNumber = fieldNumber;
        }
    }
}
