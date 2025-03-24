package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@name = 'username']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@name = 'password']")
    WebElement passwordInput;

    @FindBy(xpath = "//div/button")
    WebElement LoginButton;

    @FindBy(xpath = "//div[@role = 'alert']")
    WebElement error_message;

    public LoginPage (WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    }

    public void login() {
        usernameInput.sendKeys("Admin");
    }
    public void password() {
        passwordInput.sendKeys("admin123");
    }
    public void password2() {
        passwordInput.sendKeys("admin1234");
    }
    public void click_login_button() {
        this.LoginButton.click();
    }

    public WebElement getError_message() {
        return error_message;
    }
}
