package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateCartPage {
    private final WebDriver driver;
    public UpdateCartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By quantityBox = By.cssSelector("#content > form > div > table > tbody > tr > td:nth-child(4) > div > input");
    private final By updateButton = By.xpath("//button[@data-original-title='Update']");
    private final By UpdateAssertionMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    private final By deleteProduct = By.xpath("//button[@data-original-title='Remove']");
    private final By deleteAssertion = By.xpath("//h1[text()='Shopping Cart']");

    public void updateQuantity(String quantity){
        driver.findElement(quantityBox).clear();
        driver.findElement(quantityBox).sendKeys(quantity);
        driver.findElement(updateButton).click();
    }

    public String getUpdatedQuantityAssertionMessage(){
       return driver.findElement(UpdateAssertionMessage).getText();
    }

    public void deleteProduct(){
        driver.findElement(deleteProduct).click();
    }

    public String getDeletedProductAssertionMessage(){
        return driver.findElement(deleteAssertion).getText();
    }
}
