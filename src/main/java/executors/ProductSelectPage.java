package executors;

import com.codeborne.selenide.SelenideElement;
import locators.ProductSelectLocators;

import java.util.List;

public class ProductSelectPage {

    private ProductSelectLocators locators;

    public ProductSelectPage() {
        locators = new ProductSelectLocators();
    }

    public void expandDropDownlist() {
        locators.categoryDropDown.click();
    }

    public void pickCategory(String category) {
        selectCategory(category).click();
    }

    public boolean areProductsFromSelectedCategory(String category) {
        boolean isProperCategory = true;
        List<SelenideElement> products = locators.productsCategories;
        for (SelenideElement product : products) {
            if (!product.getText().equals(category)) {
                isProperCategory = false;
            }
        }
        return isProperCategory;
    }

    public void typeFragmentInSearchBox(String fragment) {
        locators.searchInput.val(fragment);
    }

    public String getSearchedCategory() {
        List<SelenideElement> categories = locators.listOfCategories;
        return categories.get(0).getText();
    }

    private SelenideElement selectCategory(String category) {
        List<SelenideElement> categories = locators.listOfCategories;
        for (SelenideElement element : categories) {
            if (element.getText().equals(category)) {
                return element;
            }
        }
        return null;
    }
}
