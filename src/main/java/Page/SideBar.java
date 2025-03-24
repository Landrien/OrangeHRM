package Page2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar {

    WebDriver driver;
    @FindBy(xpath = "//div/img")
    WebElement logo;

    @FindBy(xpath = "//ul/li[1]")
    WebElement AdminButton;

    @FindBy(xpath = "//ul/li[2]")
    WebElement PIMButton;

    public SideBar (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAdminButton(){
        AdminButton.click();
    }
    public void clickPIMButton(){
        PIMButton.click();
    }
    public WebElement getLogo(){
        return logo;
    }

}
