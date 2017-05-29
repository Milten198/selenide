package executors;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class DynamicContentPage {


    public void scrollToTheFooter() {
        while (!isFooterVisible()) {
            scrollPageDown();
        }
    }

    public String numberOfLoadings(){
        return String.valueOf($$(By.className("jscroll-added")).size());
    }

    public boolean isFooterVisible() {
        return $(By.cssSelector(".jscroll-inner>h3")).isDisplayed();
    }

    private void scrollPageDown() {
        executeJavaScript("window.scrollBy(0,50)");
    }
}
