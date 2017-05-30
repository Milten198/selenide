package executors;

import com.codeborne.selenide.Selenide;
import locators.PopUpFormLocators;

public class PopUpFormPage {

    private PopUpFormLocators locators;

    public PopUpFormPage() {
        locators = new PopUpFormLocators();
    }

    public void clickApplyBtn() {
        locators.applyButton.click();
    }

    public PopupFormWindow switchToPopup() {
        Selenide.switchTo().window(1);
        return new PopupFormWindow();
    }
}
