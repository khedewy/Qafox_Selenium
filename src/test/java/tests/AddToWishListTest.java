package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToWishListPage;
import pages.HomePage;
import pages.RegisterPage;
import pages.SearchPage;

import java.io.IOException;

public class AddToWishListTest extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;
    SearchPage searchPage;
    AddToWishListPage add;
    String currentTime = String.valueOf(System.currentTimeMillis());

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
    public void navigateToProduct(){
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        homePage.searchForProducts("iphone");
        Assert.assertEquals(searchPage.getFirstProductPageAssertion(),"Search - iphone");
        searchPage.navigateToFirstProduct();
        Assert.assertEquals(searchPage.getFirstProductAssertionMessage(),"iPhone");
    }

    @Test(priority = 3)
    public void addProductToWishList(){
        add = new AddToWishListPage(driver);
        add.addToWishList();
        Assert.assertEquals(add.getFirstProductAddedToWishListAssertionMessage(),"product 11");
    }

}
