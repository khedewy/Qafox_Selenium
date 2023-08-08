package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;
import pages.SearchPage;

public class AddToCartTest extends TestBase{

    HomePage homePage;
    SearchPage searchPage;
    AddToCartPage add;
    @Test
    public void searchForProduct(){
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        homePage.searchForProducts("iphone");
        Assert.assertEquals(searchPage.getFirstProductPageAssertion(),"Search - iphone");
        searchPage.navigateToFirstProduct();
        Assert.assertEquals(searchPage.getFirstProductAssertionMessage(),"iPhone");

    }

    @Test(priority = 1)
    public void addFirstProductToCart(){
        add = new AddToCartPage(driver);
        add.addProductToCart();
        Assert.assertEquals(add.getFirstProductAddedToCartAssertionMessage(),"product 11");
        add.ContinueShopping();
    }

    @Test(priority = 2)
    public void searchForSecondProduct(){
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        homePage.searchForProducts("mac");
        Assert.assertEquals(searchPage.getSecondProductPageAssertion(),"Search - mac");
        searchPage.navigateToSecondProduct();
        Assert.assertEquals(searchPage.getSecondProductAssertionMessage(),"iMac");


    }

    @Test(priority = 3)
    public void addSecondProductToCart(){
        add = new AddToCartPage(driver);
        add.addProductToCart();
        Assert.assertEquals(add.getSecondProductAddedToCartAssertionMessage(),"Product 14");

    }
}
