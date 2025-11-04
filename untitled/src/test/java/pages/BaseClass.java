package pages;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.BrowserFactory;
import utilities.ConfigDataClass;

import java.io.FileNotFoundException;

public class BaseClass {

    protected WebDriver driver;
    protected ConfigDataClass conf;

    @BeforeClass(alwaysRun = true)
    public void setup() throws FileNotFoundException, InterruptedException {
        // Load config
        conf = new ConfigDataClass();

        // Allow JVM props to override config.properties (useful in CI)
        String browser = System.getProperty("browser", conf.getBrowser());
        String url     = System.getProperty("url", conf.getUrl());

        // Start browser

        driver = BrowserFactory.startApplication(driver, browser, url);
    }

}
