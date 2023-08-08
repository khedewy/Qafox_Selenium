package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AddReviewPage {
    private final WebDriver driver;
    public AddReviewPage(WebDriver driver){
        this.driver = driver;
    }

    private final By addReviewButton = By.linkText("Write a review");
    private final By nameTxt = By.id("input-name");
    private final By reviewTxt = By.id("input-review");
    private final By rateButton = By.xpath("//input[@value='3']");
    private final By submitButton = By.id("button-review");
    private final By reviewAssertion = By.xpath("//div[@class='alert alert-success alert-dismissible']");


    public void moveToReviewFields(){
        driver.findElement(addReviewButton).click();
    }

    public void enterReviewData(String name, String review){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(nameTxt).sendKeys(name);
        driver.findElement(reviewTxt).sendKeys(review);
        driver.findElement(rateButton).click();
        driver.findElement(submitButton).click();
    }

    public String getReviewAssertionMessage(){
        return driver.findElement(reviewAssertion).getText();
    }
}
