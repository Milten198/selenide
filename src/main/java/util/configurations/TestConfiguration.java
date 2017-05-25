package util.configurations;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class TestConfiguration {

    public static final String DOWNLOAD_PATH = System.getProperty("user.dir")+ "\\downloads";
    public final static int SHORT_TIME_FOR_THREAD = 1000;

    public static void chromeProperties() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chrome//chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");

        DesiredCapabilities capabilities = null;
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        String downloadFolderPath = "D:\\Selenide\\proj\\downloads";
        chromePrefs.put("download.default_directory", downloadFolderPath);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("plugins.plugins_disabled", new String[]{"Chrome PDF Viewer"});

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-print-preview");

        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        setWebDriver(driver);
    }
}
