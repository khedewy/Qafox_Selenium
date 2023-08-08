package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver  driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    private final By registerPageAssertion = By.xpath("//h1[text()='Register Account']");
    private final By firstNameTxt = By.id("input-firstname");
    private final By lastNameTxt = By.id("input-lastname");
    private final By emailTxt = By.id("input-email");
    private final By telephoneTxt = By.id("input-telephone");
    private final By passwordTxt = By.id("input-password");
    private final By confirmPassWordTxt = By.id("input-confirm");
    private final By agreeOnServices = By.xpath("//input[@type='checkbox']");
    private final By continueButton = By.xpath("//input[@value='Continue']");
    private final By successfulRegisterMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");

    public String getRegisterPageAssertionMessage(){
        return driver.findElement(registerPageAssertion).getText();
    }
    public void enterRegisterData(String firstName, String lastName, String email, String telephone, String password){
        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(telephoneTxt).sendKeys(telephone);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(confirmPassWordTxt).sendKeys(password);
        driver.findElement(agreeOnServices).click();
        driver.findElement(continueButton).click();
    }

    public String getSuccessfulRegisterMessage(){
        return driver.findElement(successfulRegisterMessage).getText();
    }



}
