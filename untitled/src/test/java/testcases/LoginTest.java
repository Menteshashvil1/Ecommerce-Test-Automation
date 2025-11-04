package testcases;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

    @Test
    public void verify(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(conf.getEmail(),  conf.getPassword());
        Assert.assertTrue(loginPage.isLoggedIn(), "User should be logged in.");

    }

}
