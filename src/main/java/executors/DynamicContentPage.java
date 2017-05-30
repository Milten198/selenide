package executors;

import locators.DynamicContentLocators;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DynamicContentPage {

    private DynamicContentLocators locators;

    public DynamicContentPage() {
        locators = new DynamicContentLocators();
    }

    public void scrollToTheFooter() {
        while (!isFooterVisible()) {
            scrollPageDown();
        }
    }

    public String numberOfLoadings() {
        return String.valueOf(locators.loadedFragments.size());
    }

    public boolean isFooterVisible() {
        return locators.footer.isDisplayed();
    }

    private void scrollPageDown() {
        executeJavaScript("window.scrollBy(0,50)");
    }
}
