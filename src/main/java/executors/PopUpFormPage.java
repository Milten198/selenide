package executors;


import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PopUpFormPage {

    public void clickApplyBtn() {
        $(By.cssSelector(".btn.btn-primary.btn-block.js-open-window")).click();
    }

    public void switchToPopup() {
        Selenide.switchTo().window(1);
    }
}
