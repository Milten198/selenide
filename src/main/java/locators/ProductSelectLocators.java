package locators;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductSelectLocators {

    public SelenideElement categoryDropDown = $(".select2-selection__arrow");
    public List<SelenideElement> productsCategories = $$(".caption>p>strong");
    public SelenideElement searchInput = $(".select2-search__field");
    public List<SelenideElement> listOfCategories = $$(By.xpath("//span[2]/ul/li"));



}
