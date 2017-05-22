package hooks;

import cucumber.api.java.Before;
import util.configurations.TestConfiguration;

public class BeforeHooks {


    @Before()
    public void initBrowser() {
        TestConfiguration.chromeProperties();
    }
}
