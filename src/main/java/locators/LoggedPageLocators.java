package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoggedPageLocators {

    public SelenideElement logoutLink = $(By.id("logout"));
    public SelenideElement downloadLink = $(By.cssSelector(".col-md-offset-5.col-md-7>a"));
}
