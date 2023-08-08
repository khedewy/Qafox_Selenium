package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private final WebDriver driver;
    Select select;
    WebDriverWait wait;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    private final By checkOutButton = By.linkText("Checkout");
    private final By firstNameTxt = By.id("input-payment-firstname");
    private final By lasNameTxt = By.id("input-payment-lastname");
    private final By companyTxt = By.id("input-payment-company");
    private final By addressOneTxt = By.id("input-payment-address-1");
    private final By addressTowTxt = By.id("input-payment-address-2");
    private final By cityTxt = By.id("input-payment-city");
    private final By postCodeTxt = By.id("input-payment-postcode");
    private final By countryTxt = By.id("input-payment-country");
    private final By regionTxt = By.id("input-payment-zone");
    private final By confirmAddress = By.id("button-payment-address");
    private final By confirmShippingAddress = By.id("button-shipping-address");
    private final By confirmShippingMethode = By.id("button-shipping-method");
    private final By agreeServices = By.name("agree");
    private final By confirmPaymentMethode = By.id("button-payment-method");
    private final By confirmOrder = By.id("button-confirm");
    private final By assertionMessage = By.xpath("//h1[text()='Your order has been placed!']");



    public void navigateToCheckOutPage(){
        driver.findElement(checkOutButton).click();
    }

    public void enterAddressDetails(String firstName, String lastName,
                                     String company, String address1, String address2,
                                     String city, String postCode, String country, String region){

        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lasNameTxt).sendKeys(lastName);
        driver.findElement(companyTxt).sendKeys(company);
        driver.findElement(addressOneTxt).sendKeys(address1);
        driver.findElement(addressTowTxt).sendKeys(address2);
        driver.findElement(cityTxt).sendKeys(city);
        driver.findElement(postCodeTxt).sendKeys(postCode);
        select = new Select(driver.findElement(countryTxt));
        select.selectByVisibleText(country);
        select = new Select(driver.findElement(regionTxt));
        select.selectByVisibleText(region);
        driver.findElement(confirmAddress).click();

    }

    public void setConfirmShoppingAddress(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(confirmShippingAddress)));
        driver.findElement(confirmShippingAddress).click();
    }

    public void setConfirmShoppingMethode(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(confirmShippingMethode)));
        driver.findElement(confirmShippingMethode).click();
    }

    public void setConfirmPaymentMethode(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.findElement(agreeServices).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(confirmPaymentMethode)));
        driver.findElement(confirmPaymentMethode).click();
    }

    public void confirmOrder(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(confirmOrder)));
        driver.findElement(confirmOrder).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }
}
