package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AddToCartPage {
    private final WebDriver driver;
    public AddToCartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By addToCartButton = By.id("button-cart");
    private final By showCartButton = By.linkText("shopping cart");
    private final By continueShoppingButton = By.linkText("Continue Shopping");


    private final By firstProductAddedToCartAssertionMessage = By.xpath("//td[text()='product 11']");
    private final By secondProductAddedToCartAssertionMessage = By.xpath("//td[text()='Product 14']");

    public void addProductToCart(){
        driver.findElement(addToCartButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(showCartButton).click();
    }

    public void ContinueShopping(){
        driver.findElement(continueShoppingButton).click();
    }

    public String getFirstProductAddedToCartAssertionMessage(){
        return driver.findElement(firstProductAddedToCartAssertionMessage).getText();
    }

    public String getSecondProductAddedToCartAssertionMessage(){
        return driver.findElement(secondProductAddedToCartAssertionMessage).getText();
    }
}
