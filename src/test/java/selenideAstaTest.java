import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class selenideAstaTest {

    @Test
    public void userCanLoginByUsername() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chrome//chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("https://testingcup.pgs-soft.com/task_6");
        $(By.id("LoginForm__username")).val("tester");
        $(By.id("LoginForm__password")).val("123-xyz");
        $(By.id("LoginForm_save")).click();
        $(By.cssSelector(".col-md-offset-5.col-md-7>a")).shouldBe(visible).shouldHave(text("Pobierz plik"));
    }
}
