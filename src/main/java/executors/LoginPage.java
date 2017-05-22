package executors;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    public void verifyLoginPageIsVisible() {
        $(By.id("LoginForm_save")).shouldBe(visible).shouldHave(text("Login"));
    }

    public void setLogin(String login) {
        $(By.id("LoginForm__username")).val(login);
    }

    public void setPassword(String password) {
        $(By.id("LoginForm__password")).val(password);
    }

    public void clickLoginBtn() {
        $(By.id("LoginForm_save")).click();
    }

    public void verifyLoginErrorMessage(String message) {
        $(By.cssSelector(".list-unstyled>li")).shouldBe(visible).shouldHave(text("Nieprawidłowe dane logowania"));
    }
}
