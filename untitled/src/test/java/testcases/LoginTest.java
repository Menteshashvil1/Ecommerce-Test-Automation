package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

    LoginPage loginPage = new LoginPage(driver);

    @Test()
    public void initPage() {
        if (driver == null) throw new IllegalStateException("Driver is null in @BeforeMethod");
        System.out.println("URL: " + driver.getCurrentUrl());  // sanity check
        loginPage = new LoginPage(driver);
        loginPage.login(conf.getEmail(),  conf.getPassword());
    }
}
