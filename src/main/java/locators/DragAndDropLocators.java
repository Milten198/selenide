package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DragAndDropLocators {

    public SelenideElement totalQuantity = $(".row-in-basket-quantity");
    public SelenideElement totalPrice = $(".summary-price");
    public SelenideElement drop = $(".col-md-12.place-to-drop.ui-droppable");

    public SelenideElement product(String productName) {
        return $(By.xpath(String.format("//div[2][h4='%s']/div/input", productName)));
    }

    public SelenideElement logoToDrag(String logoNumber) {
        return $(By.xpath(String.format("//div[img][following-sibling::div/h4[text() = '%s']]", logoNumber)));
    }
}
