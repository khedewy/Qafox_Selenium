package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private final WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    private final By FirstProductPageAssertion = By.xpath("//h1[text()='Search - iphone']");
    private final By firstProduct = By.linkText("iPhone");
    private final By firstProductAssertion = By.xpath("//h1[text()='iPhone']");
    private final By secondProduct = By.linkText("iMac");
    private final By secondProductAssertionMessage = By.xpath("//h1[text()='iMac']");
    private final By SecondProductPageAssertion = By.xpath("//h1[text()='Search - mac']");
    private final By thirdProduct = By.linkText("MacBook Air");





    public String getFirstProductPageAssertion(){
        return driver.findElement(FirstProductPageAssertion).getText();
    }

    public void navigateToFirstProduct(){
        driver.findElement(firstProduct).click();
    }
    public String getFirstProductAssertionMessage(){
        return driver.findElement(firstProductAssertion).getText();
    }

    public String getSecondProductPageAssertion(){
        return driver.findElement(SecondProductPageAssertion).getText();
    }
    public void navigateToSecondProduct(){
        driver.findElement(secondProduct).click();
    }

    public String getSecondProductAssertionMessage(){
        return driver.findElement(secondProductAssertionMessage).getText();
    }

    public void ProductToBeCheckedOut(){
        driver.findElement(thirdProduct).click();
    }

}
