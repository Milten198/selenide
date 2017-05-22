package hooks;


import cucumber.api.java.After;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class AfterHooks {

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
