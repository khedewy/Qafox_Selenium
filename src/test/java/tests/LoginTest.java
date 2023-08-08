package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.io.IOException;

public class LoginTest extends TestBase{

    HomePage homePage;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());
    LoginPage loginPage;

    @Test
    public void navigateToRegisterPage(){
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new RegisterPage(driver);
        Assert.assertEquals(registerPage.getRegisterPageAssertionMessage(),"Register Account");
    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.testData();
        registerPage = new RegisterPage(driver);
        registerPage.enterRegisterData(data.firstName, data.lastName, data.email+currentTime+"@gmail.com", data.telephone, data.password);
        Assert.assertEquals(registerPage.getSuccessfulRegisterMessage(),"Your Account Has Been Created!");
    }

    @Test(priority = 2)
    public void logOutAndNavigateToLogin(){
        homePage = new HomePage(driver);
        homePage.logOut();
        homePage.navigateToLoginPage();
        loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.getLoginPageAssertionMessage(),"New Customer");
    }

    @Test(priority = 3)
    public void login() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.testData();
        loginPage = new LoginPage(driver);
        loginPage.enterLoginData(data.email+currentTime+"@gmail.com", data.password);
        Assert.assertEquals(loginPage.getSuccessfulLoginAssertionMessage(),"My Account");
    }
}
