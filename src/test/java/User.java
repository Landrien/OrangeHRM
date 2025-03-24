import Page.AddUser;
import Page.Admin;
import Page.LoginPage;
import org.testng.annotations.Test;

import java.time.Duration;

public class User extends BaseTest{
    @Test
    public void CreateUser() {
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage.login();
        loginPage.password();
        loginPage.click_login_button();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Admin admin = new Admin(driver);
        admin.clickAddButton();
        AddUser user = new AddUser(driver);
        user.openUserRoleList();
        user.selectUserRole();
        user.openUserStatusList();
        user.selectUserStatus();
        user.saisir_EmployeeName("Hadrien");
        user.saisir_Username("Hadrien");
        user.saisir_Password("Hadrien");
        user.saisir_ConfirmPassword("Hadrien");
        user.SaveButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void ModifUser(){
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage.login();
        loginPage.password();
        loginPage.click_login_button();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Admin admin = new Admin(driver);
        admin.clickArrowButton();
        admin.saisir_UsernameField("Hadrien");
        admin.clickSearchButton();


        admin.clickEditButton();
        AddUser user = new AddUser(driver);
        user.modifUserName();
        user.SaveButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void DeleteUser(){
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage.login();
        loginPage.password();
        loginPage.click_login_button();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Admin admin = new Admin(driver);
        admin.clickArrowButton();
        admin.saisir_UsernameField("Hadrien");
        admin.clickSearchButton();
        admin.clickDeleteButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
