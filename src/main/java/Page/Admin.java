package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin {
    WebDriver driver;
    @FindBy(xpath = "//h6[1]")
    WebElement AdminTitle;
    @FindBy(xpath = "//div[@class = 'orangehrm-header-container']/button")
    WebElement AddButton;
    @FindBy(xpath = "//div[@class = '--toggle']/button")
    WebElement ArrowButton;
    @FindBy(xpath = "//div[@class = 'oxd-input-group oxd-input-field-bottom-space']/div/input[@class = 'oxd-input oxd-input--active']")
    WebElement UsernameField;
    @FindBy(xpath = "//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement SearchButton;
    @FindBy (xpath = "//button[@class = 'oxd-icon-button oxd-table-cell-action-space'][2]")
    WebElement EditButton;
    @FindBy (xpath = "//button[@class = 'oxd-icon-button oxd-table-cell-action-space'][1]")
    WebElement DeleteButton;

    public Admin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddButton() {
        AddButton.click();
    }
    public void clickArrowButton() {
        ArrowButton.click();
    }
    public void saisir_UsernameField(String username) {
        UsernameField.sendKeys(username);
    }
    public void clickSearchButton() {
        SearchButton.click();
    }
    public WebElement getAdminTitle() {
        return AdminTitle;
    }
    public void clickEditButton() {
        EditButton.click();
    }
    public void clickDeleteButton() {
        DeleteButton.click();
    }



}
