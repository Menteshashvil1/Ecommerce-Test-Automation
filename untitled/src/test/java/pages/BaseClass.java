package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.BrowserFactory;
import utilities.ConfigDataClass;

import java.io.FileNotFoundException;
import java.time.Duration;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigDataClass conf;


    @BeforeClass(alwaysRun = true)
    public void setup() throws FileNotFoundException, InterruptedException {
        // Load config
        conf = new ConfigDataClass();

        // Allow JVM props to override config.properties (useful in CI)
        String browser = System.getProperty("browser", conf.getBrowser());
        String url     = System.getProperty("url", conf.getUrl());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Start browser

        driver = BrowserFactory.startApplication(driver, browser, url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }


    public WebDriver getDriver() { return driver; }
    public WebDriverWait getWait() { return wait; }
    public ConfigDataClass getConf() { return conf; }

}
