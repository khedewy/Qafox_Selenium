package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AddToWishListPage {
    private final WebDriver driver;
    public AddToWishListPage(WebDriver driver){
        this.driver = driver;
    }

    private final By addToWishListButton = By.xpath("//button[@data-original-title='Add to Wish List']");
    private final By showWishList = By.linkText("wish list");
    private final By firstProductAddedToWishListAssertionMessage = By.xpath("//td[text()='product 11']");


    public void addToWishList(){
        driver.findElement(addToWishListButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(showWishList).click();
    }

    public String getFirstProductAddedToWishListAssertionMessage(){
        return driver.findElement(firstProductAddedToWishListAssertionMessage).getText();
    }

}


