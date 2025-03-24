import Page.Admin;
import Page.LoginPage;
import Page.SideBar;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class ConnexionTest extends BaseTest{



    @Test
    public void connexionTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage.login();
        loginPage.password();
        loginPage.click_login_button();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Admin admin = new Admin(driver);
        Assert.assertEquals(admin.getAdminTitle().getText(), "Dashboard");

    }

    @Test
    public void connexionFailTest() {
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage.login();
        loginPage.password2();
        loginPage.click_login_button();
        Assert.assertTrue(loginPage.getError_message().isDisplayed());
    }

}
