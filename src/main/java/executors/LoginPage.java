package executors;

import locators.LoginPageLocators;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    private LoginPageLocators locators;

    public LoginPage() {
        locators = new LoginPageLocators();
    }

    public void verifyLoginPageIsVisible() {
        locators.loginButton.shouldBe(visible).shouldHave(text("Login"));
    }

    public void setLogin(String login) {
        locators.loginInput.val(login);
    }

    public void setPassword(String password) {
        locators.passwordInput.val(password);
    }

    public void clickLoginBtn() {
        locators.loginButton.click();
    }

    public void verifyLoginErrorMessage(String message) {
        locators.errorMessage.shouldBe(visible).shouldHave(text(message));
    }
}
