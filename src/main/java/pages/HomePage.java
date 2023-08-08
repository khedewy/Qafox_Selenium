package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;

    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By accountManager = By.xpath("//a[@title='My Account']");
    private final By registerButton = By.xpath("//a[text()='Register']");
    private final By logoutButton = By.linkText("Logout");
    private final By loginButton = By.linkText("Login");
    private final By searchBox = By.name("search");
    private final By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");

    public RegisterPage navigateToRegisterPage(){
        driver.findElement(accountManager).click();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(registerButton)));
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    public void logOut(){
        driver.findElement(accountManager).click();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(logoutButton)));
        driver.findElement(logoutButton).click();
    }

    public LoginPage navigateToLoginPage(){
        driver.findElement(accountManager).click();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginButton)));
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public SearchPage searchForProducts(String product){
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }
}
