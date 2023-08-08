package tests;

import data.CheckOutData;
import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class CheckOuTest extends TestBase{

    HomePage homePage;
    RegisterPage registerPage;
    SearchPage searchPage;
    AddToCartPage add;
    CheckoutPage checkoutPage;
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
    public void searchForSecondProduct(){
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        homePage.searchForProducts("mac");
        Assert.assertEquals(searchPage.getSecondProductPageAssertion(),"Search - mac");
        searchPage.ProductToBeCheckedOut();
    }

    @Test(priority = 3)
    public void addSecondProductToCart(){
        add = new AddToCartPage(driver);
        add.addProductToCart();
    }

    @Test(priority = 4)
    public void navigateAndEnterAddressDetails() throws IOException, ParseException {
        CheckOutData data = new CheckOutData();
        data.testData();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.navigateToCheckOutPage();
        checkoutPage.enterAddressDetails(data.firstName, data.lastName, data.company,
                data.addressOne, data.addressTow, data.city, data.postCode,data.country, data.region);
    }
    @Test(priority = 5)
    public void completeCheckOut(){
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.setConfirmShoppingAddress();
        checkoutPage.setConfirmShoppingMethode();
        checkoutPage.setConfirmPaymentMethode();
        checkoutPage.confirmOrder();
        Assert.assertEquals(checkoutPage.getAssertionMessage(),"Your order has been placed!");
    }
}
