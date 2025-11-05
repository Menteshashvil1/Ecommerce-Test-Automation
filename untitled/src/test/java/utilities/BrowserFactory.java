package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browser,String url){
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-blink-features=AutomationControlled");
                options.addArguments("--no-sandbox"); // Often useful in headless environments
                options.addArguments("--disable-dev-shm-usage"); // Often useful in headless environments
                options.addArguments("--disable-gpu"); // Often useful in headless environments
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                options.setExperimentalOption("useAutomationExtension", false);
                driver = new ChromeDriver(options);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                ChromeOptions options = new ChromeOptions();
                driver = new FirefoxDriver();
            }
            case "ie" -> {
                WebDriverManager.edgedriver().setup();
                ChromeOptions options = new ChromeOptions();
                driver = new EdgeDriver();
            }
            default -> System.out.println("Browser not supported");
        }

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(20));
        return driver;
    };
}