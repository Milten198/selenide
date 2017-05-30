package executors;

import com.codeborne.selenide.SelenideElement;
import locators.BasketOperationsLocators;
import org.openqa.selenium.By;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketOperationsPage {

    private BasketOperationsLocators locators;

    public BasketOperationsPage() {
        locators = new BasketOperationsLocators();
    }

    public BasketOperationsPage setQuantityOfProduct(String productName, String quantity) {
        locators.productInput(productName).val(quantity);
        return this;
    }

    public void addProductToBasket(String productName) {
       locators.addProduct(productName).click();
    }

    public boolean verifyTotalQuantity() {
        return getTotalQuantity().equals(locators.totalQuantity.getText());
    }

    public boolean verifyTotalPrice() {
        return getTotalPrice().equals(locators.totalPrice.getText());
    }

    public boolean verifyNumberOfProductsInBasket(String numberOfProducts) {
        return String.valueOf(locators.listOfProductInBasket.size()).equals(numberOfProducts);
    }

    public void removeProductFromBasket(String productName) {
        locators.removeProductFromBasket(productName).click();
    }

    public boolean isProductNotInBasket(String productName) {
        return !locators.productInBasket(productName).is(visible);
    }

    private String getTotalQuantity() {
        int totalQuantity = 0;
        for (SelenideElement product : locators.listOfQuantitiesInBasket) {
            totalQuantity += Integer.parseInt(product.getText());
        }
        return String.valueOf(totalQuantity);
    }

    private String getTotalPrice() {
        List<SelenideElement> products = locators.listOfProductInBasket;
        float totalPrice = 0;
        for (int i = 0; i < products.size(); i++) {
            String productPrice = products.get(i).getText().substring(products.get(i).getText().indexOf('(') + 1, products.get(i).getText().indexOf(')'));
            totalPrice += Float.parseFloat(productPrice) * Float.parseFloat(locators.listOfQuantitiesInBasket.get(i).getText());
        }
        return round(totalPrice, 2) + " zł";
    }

    private static String round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, RoundingMode.HALF_EVEN);
        return bd.toString();
    }
}
