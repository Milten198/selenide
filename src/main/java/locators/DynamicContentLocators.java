package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DynamicContentLocators {

    public SelenideElement footer = $(By.cssSelector(".jscroll-inner>h3"));
    public List<SelenideElement> loadedFragments = $$(By.className("jscroll-added"));
}
