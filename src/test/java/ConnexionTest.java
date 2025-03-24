import BaseTest.BaseTest;
import Page.LoginPage;
import Page.SideBar;
import org.testng.Assert;
import org.testng.annotations.*;

import static BaseTest.BaseTest.driver;

public class ConnexionTest {



    @Test
    public void connexionTest() {
        LoginPage loginPage = new LoginPage(BaseTest.driver);
        loginPage.login("Admin");
        loginPage.password("admin123");
        loginPage.click_login_button();
        SideBar sideBar = new SideBar(driver);
        Assert.assertTrue(sideBar.getLogo().isDisplayed());

    }

    @Test
    public void connexionFailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin");
        loginPage.password("admin1234");
        loginPage.click_login_button();
        Assert.assertTrue(loginPage.getError_message().isDisplayed());
    }

}
