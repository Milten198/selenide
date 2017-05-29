package executors;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketOperationsPage {

    public BasketOperationsPage setQuantityOfProduct(String productName, String quantity) {
        $(By.xpath(String.format("//div[h4[contains(text(), '%s')]]/div/input", productName))).val(quantity);
        return this;
    }

    public BasketOperationsPage addProductToBasket(String productName) {
        $(By.xpath(String.format("//div[h4[contains(text(), '%s')]]/div/span", productName))).click();
        return this;
    }

    public boolean verifyTotalQuantity() {
        return getTotalQuantity().equals($(".summary-quantity").getText());
    }

    public boolean verifyTotalPrice() {
        return getTotalPrice().equals($(".summary-price").getText());
    }

    public String numberOfProductsInBasket() {
        return String.valueOf($$(".col-md-9.text-on-button-level").size());
    }

    public void removeProductFromBasket(String productName) {
        $(By.xpath(String.format("//button[@data-product-name = '%s'][contains(text(), 'Usuń')]", productName))).click();
    }

    public boolean isProductNotInBasket(String productName) {
        return !$(By.xpath(String.format("//div[contains(text(), '%s')]", productName))).is(visible);
    }

    private String getTotalQuantity() {
        List<SelenideElement> products = $$(".row-in-basket-quantity");
        int totalQuantity = 0;
        for (SelenideElement product : products) {
            totalQuantity += Integer.parseInt(product.getText());
        }
        return String.valueOf(totalQuantity);
    }

    private String getTotalPrice() {
        List<SelenideElement> products = $$(".col-md-9.text-on-button-level");
        float totalPrice = 0;
        for (int i = 0; i < products.size(); i++) {
            String productPrice = products.get(i).getText().substring(products.get(i).getText().indexOf('(') + 1, products.get(i).getText().indexOf(')'));
            totalPrice += Float.parseFloat(productPrice) * Float.parseFloat($$(".row-in-basket-quantity").get(i).getText());
        }
        return round(totalPrice, 2) + " zł";
    }

    private static String round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, RoundingMode.HALF_EVEN);
        return bd.toString();
    }
}
