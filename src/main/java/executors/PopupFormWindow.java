package executors;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import locators.PopUpFormWindowLocators;

import static com.codeborne.selenide.Selenide.$;
import static locators.PopUpFormWindowLocators.FormFields;

public class PopupFormWindow {

    private PopUpFormWindowLocators locators;

    public PopupFormWindow() {
        locators = new PopUpFormWindowLocators();
    }

    public void switchToFrame() {
        Selenide.switchTo().frame(locators.frame);
    }

    public boolean isAlertDisplayedAndFocused() {
        return locators.saveButton.is(Condition.visible);
    }

    public void setName(String name) {
        locators.name.val(name);
    }

    public void setEmail(String email) {
        locators.email.val(email);
    }

    public void setPhoneNumber(String phoneNumber) {
        locators.phone.val(phoneNumber);
    }

    public void clickSaveBtn() {
        locators.saveButton.click();
    }

    public String getConfirmationMessage() {
        return locators.confirmationMessage.getText();
    }

    public String getErrorMessage(FormFields field) {
        return $(locators.formFieldLocator(field)).getText();
    }

}
