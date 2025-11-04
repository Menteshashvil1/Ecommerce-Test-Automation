package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BaseClass {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/a/span")
    private WebElement myAccountDropdown;

    @FindBy(xpath = "//a[contains(@href,'route=account/login')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"input-email\"]")
    private WebElement  emailField;

    @FindBy(xpath = "//*[@id=\"input-password\"]")
    private WebElement  passwordField;

    @FindBy(xpath = "//form[@id='form-login']//button[@type='submit']")
    private WebElement  loginButton;

    @FindBy(xpath = "//a[@title='My Account' or .//span[normalize-space()='My Account']]")
    private WebElement myAccountAfterLogin;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void login(String email, String password) {
        myAccountDropdown.click();
        loginField.click();
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }
    public boolean isLoggedIn() {
        try {
            myAccountAfterLogin.click(); // open dropdown
            boolean present = logoutLink.isDisplayed();
            myAccountAfterLogin.click(); // close dropdown (optional)
            return present;
        } catch (Exception e) {
            return false;
        }
    }














}
