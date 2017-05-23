package executors;


import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getElement;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DragAndDropPage {

    public void setQuantity(String productNumber, String quantity) {
        $(product(productNumber)).val(quantity);
    }

    public String totalQuantityOfProducts() {
        return $(".row-in-basket-quantity").getText();
    }

    public String totalPriceToPay() {
        return $(".summary-price").getText();
    }

    public void dragProductLogo(String logoNumber) {
        WebElement drag = getElement(logo(logoNumber));
        dragAndDropElementWithoutWait(drag, getElement(By.cssSelector(".col-md-12.place-to-drop.ui-droppable")));
    }

    private void dragAndDropElementWithoutWait(WebElement drag, WebElement drop) {
        Actions actions = new Actions(getWebDriver());
        actions.dragAndDrop(drag, drop)
                .build()
                .perform();
    }

    private By product(String productName) {
        return By.xpath(String.format("//div[2][h4='%s']/div/input", productName));
    }

    private By logo(String logoNumber) {
        return By.xpath(String.format("//div[img][following-sibling::div/h4[text() = '%s']]", logoNumber));
    }
}
