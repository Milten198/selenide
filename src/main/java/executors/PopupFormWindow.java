package executors;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getElement;

public class PopupFormWindow {

    public void switchToFrame() {
        Selenide.switchTo().frame(getElement(By.xpath("//iframe")));
    }

    public boolean isAlertDisplayedAndFocused() {
        return $(By.id("save-btn")).is(Condition.visible);
    }

    public void setName(String name) {
        $(By.xpath("//input[@name='name']")).val(name);
    }

    public void setEmail(String email) {
        $(By.xpath("//input[@name='email']")).val(email);
    }

    public void setPhoneNumber(String phoneNumber) {
        $(By.xpath("//input[@name='phone']")).val(phoneNumber);
    }

    public void clickSaveBtn() {
        $(By.id("save-btn")).click();
    }

    public String getConfirmationMessage() {
        return $(By.cssSelector(".container>h1")).getText();
    }

    public String getErrorMessage(FormFields field) {
        return $(formFieldLocator(field)).getText();
    }

    private By formFieldLocator(FormFields field) {
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
