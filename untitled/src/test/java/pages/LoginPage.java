package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginPage{

    public LoginPage(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(xpath = "//*[@id=\"search\"]/input")  // both classes
    private WebElement myAccountDropdown;

    @FindBy(css = "a.dropdown-item[href*='route=account/login']")
    private WebElement loginField;

//    @FindBy(xpath = "//*[@id=\"input-email\"]")
//    private WebElement  emailField;
//
//    @FindBy(xpath = "//*[@id=\"input-password\"]")
//    private WebElement  passwordField;
//
//    @FindBy(xpath = "//form[@id='form-login']//button[@type='submit']")
//    private WebElement  loginButton;
//
//    @FindBy(xpath = "//a[@title='My Account'")
//    private WebElement myAccountAfterLogin;
//
//    @FindBy(xpath = "//a[normalize-space()='Logout']")
//    private WebElement logoutLink;



    public void login(String email, String password) {
        myAccountDropdown.sendKeys(email);
        loginField.click();
//        emailField.clear();
//        emailField.sendKeys(email);
//        passwordField.clear();
//        passwordField.sendKeys(password);
//        loginButton.click();
    }
//    public boolean isLoggedIn() {
//        try {
//            myAccountAfterLogin.click(); // open dropdown
//            boolean present = logoutLink.isDisplayed();
//            myAccountAfterLogin.click(); // close dropdown (optional)
//            return present;
//        } catch (Exception e) {
//            return false;
//        }
//    }














}