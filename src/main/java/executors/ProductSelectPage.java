package executors;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.getElements;

public class ProductSelectPage {

    public void expandDropDownlist() {
        $(".select2-selection__arrow").click();
    }

    public void pickCategory(String category) {
        selectCategory(category).click();
    }

    public boolean areProductsFromSelectedCategory(String category) {
        boolean isProperCategory = true;
        List<SelenideElement> products = getElements(By.cssSelector(".caption>p>strong"));
        for (SelenideElement product : products) {
            if (!product.getText().equals(category)) {
                isProperCategory = false;
            }
        }
        return isProperCategory;
    }

    public void typeFragmentInSearchBox(String fragment) {
        $(".select2-search__field").val(fragment);
    }

    public String getSelectedCategory() {
        List<SelenideElement> categories = getElements(By.xpath("//span[2]/ul/li"));
        return categories.get(0).getText();
    }

    private SelenideElement selectCategory(String category) {
        List<SelenideElement> categories = $$(".select2-results__option");
        for (SelenideElement element : categories) {
            if (element.getText().equals(category)) {
                return element;
            }
        }
        return null;
    }
}
