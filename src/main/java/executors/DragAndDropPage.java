package executors;


import com.codeborne.selenide.SelenideElement;
import locators.DragAndDropLocators;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DragAndDropPage {

    DragAndDropLocators locators;

    public DragAndDropPage() {
        locators = new DragAndDropLocators();
    }

    public void setQuantity(String productNumber, String quantity) {
        locators.product(productNumber).val(quantity);
    }

    public String totalQuantityOfProducts() {
        return locators.totalQuantity.getText();
    }

    public String totalPriceToPay() {
        return locators.totalPrice.getText();
    }

    public void dragProductLogo(String logoNumber) {
        dragAndDropElementWithoutWait(locators.logoToDrag(logoNumber), locators.drop);
    }

    private void dragAndDropElementWithoutWait(SelenideElement drag, SelenideElement drop) {
        Actions actions = new Actions(getWebDriver());
        actions.dragAndDrop(drag, drop)
                .build()
                .perform();
    }


}
