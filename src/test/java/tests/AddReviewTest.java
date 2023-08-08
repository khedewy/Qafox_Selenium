package tests;

import data.ReviewData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddReviewPage;
import pages.HomePage;
import pages.SearchPage;

import java.io.IOException;

public class AddReviewTest extends TestBase{
    HomePage homePage;
    SearchPage searchPage;
    AddReviewPage add;
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
    public void addReview() throws IOException, ParseException {
        ReviewData data = new ReviewData();
        data.testData();

        add = new AddReviewPage(driver);
        add.moveToReviewFields();
        add.enterReviewData(data.name, data.review);
        Assert.assertEquals(add.getReviewAssertionMessage(),"Thank you for your review. It has been submitted to the webmaster for approval.");
    }
}
