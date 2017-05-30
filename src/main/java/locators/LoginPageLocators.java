package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageLocators {

    public SelenideElement loginInput = $(By.id("LoginForm__username"));
    public SelenideElement passwordInput = $(By.id("LoginForm__password"));
    public SelenideElement loginButton = $(By.id("LoginForm_save"));
    public SelenideElement errorMessage = $(By.cssSelector(".list-unstyled>li"));
}
