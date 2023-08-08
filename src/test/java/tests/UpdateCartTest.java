package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;
import pages.SearchPage;
import pages.UpdateCartPage;

public class UpdateCartTest extends TestBase{

    HomePage homePage;
    SearchPage searchPage;
    AddToCartPage add;
    UpdateCartPage update;
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
    }

    @Test(priority = 2)
    public void updateQuantity(){
        update = new UpdateCartPage(driver);
        update.updateQuantity("3");
        Assert.assertTrue(update.getUpdatedQuantityAssertionMessage().contains("Success: You have modified your shopping cart!"));
    }

    @Test(priority = 3)
    public void deleteItem(){
        update = new UpdateCartPage(driver);
        update.deleteProduct();
        Assert.assertEquals(update.getDeletedProductAssertionMessage(),"Shopping Cart");
    }
}
