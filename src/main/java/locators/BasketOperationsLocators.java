package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketOperationsLocators {

    public SelenideElement totalQuantity = $(".summary-quantity");
    public SelenideElement totalPrice = $(".summary-price");
    public List<SelenideElement> listOfProductInBasket = $$(".col-md-9.text-on-button-level");
    public List<SelenideElement> listOfQuantitiesInBasket = $$(".row-in-basket-quantity");

    public SelenideElement productInput(String productName) {
        return $(By.xpath(String.format("//div[h4='%s']/div/input", productName)));
    }

    public SelenideElement addProduct(String productName) {
        return $(By.xpath(String.format("//div[h4='%s']/div/span/button", productName)));
    }

    public SelenideElement removeProductFromBasket(String productName) {
        return $(By.xpath(String.format("//button[@data-product-name = '%s'][contains(text(), 'Usu')]", productName)));
    }

    public SelenideElement productInBasket(String productName) {
        return $(By.xpath(String.format("//div[contains(text(), '%s')]", productName)));
    }
}
